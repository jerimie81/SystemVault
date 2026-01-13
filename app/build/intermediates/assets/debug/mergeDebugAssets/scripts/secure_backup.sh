#!/system/bin/sh
# SystemVault backup script.
# Args:
#   $1 = backup path
#   $2 = exclude /data/media flag (1/0)
#   $3 = exclude /data/cache flag (1/0)

set -e

BACKUP_PATH="$1"
EXCLUDE_MEDIA="${2:-0}"
EXCLUDE_CACHE="${3:-1}"
TIMESTAMP=$(date +"%Y%m%d_%H%M%S")
ARCHIVE_NAME="systemvault_backup_${TIMESTAMP}.tar.gz"
MIN_FREE_KB=524288

PATH="/system/bin:/system/xbin:/vendor/bin:/vendor/xbin:$PATH"

resolve_bin() {
  if command -v "$1" >/dev/null 2>&1; then
    command -v "$1"
    return 0
  fi
  return 1
}

TAR_BIN=$(resolve_bin tar || true)
if [ -z "$TAR_BIN" ] && command -v busybox >/dev/null 2>&1; then
  TAR_BIN="busybox tar"
fi

if [ -z "$TAR_BIN" ]; then
  echo "ERROR: tar not found"
  exit 3
fi

if [ -z "$BACKUP_PATH" ]; then
  echo "ERROR: Backup path missing"
  exit 2
fi

mkdir -p "$BACKUP_PATH"

AVAILABLE_KB=$(df -k "$BACKUP_PATH" | awk 'NR==2 {print $4}')
if [ -z "$AVAILABLE_KB" ] || [ "$AVAILABLE_KB" -lt "$MIN_FREE_KB" ]; then
  echo "ERROR: insufficient storage"
  exit 4
fi

echo "PROGRESS: 5"
echo "Starting backup to $BACKUP_PATH/$ARCHIVE_NAME"

tar_opts="-czf"
extra_opts=""
if "$TAR_BIN" --help 2>/dev/null | grep -q "--xattrs"; then
  extra_opts="--xattrs --xattrs-include='*'"
fi
if "$TAR_BIN" --help 2>/dev/null | grep -q "--acls"; then
  extra_opts="$extra_opts --acls"
fi

EXCLUDES=""
if [ "$EXCLUDE_MEDIA" = "1" ]; then
  EXCLUDES="$EXCLUDES --exclude=/data/media"
fi
if [ "$EXCLUDE_CACHE" = "1" ]; then
  EXCLUDES="$EXCLUDES --exclude=/data/cache --exclude=/cache"
fi

TARGET="$BACKUP_PATH/$ARCHIVE_NAME"

echo "PROGRESS: 25"
# shellcheck disable=SC2086
$TAR_BIN $extra_opts $EXCLUDES $tar_opts "$TARGET" /data

echo "PROGRESS: 90"
if [ ! -s "$TARGET" ]; then
  echo "ERROR: backup archive empty"
  exit 5
fi

echo "PROGRESS: 100"
echo "Backup complete: $TARGET"
