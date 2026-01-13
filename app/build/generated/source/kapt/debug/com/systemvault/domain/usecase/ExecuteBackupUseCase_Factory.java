package com.systemvault.domain.usecase;

import com.systemvault.data.repository.ShellRepository;
import com.systemvault.data.repository.StorageRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ExecuteBackupUseCase_Factory implements Factory<ExecuteBackupUseCase> {
  private final Provider<ShellRepository> shellRepositoryProvider;

  private final Provider<StorageRepository> storageRepositoryProvider;

  public ExecuteBackupUseCase_Factory(Provider<ShellRepository> shellRepositoryProvider,
      Provider<StorageRepository> storageRepositoryProvider) {
    this.shellRepositoryProvider = shellRepositoryProvider;
    this.storageRepositoryProvider = storageRepositoryProvider;
  }

  @Override
  public ExecuteBackupUseCase get() {
    return newInstance(shellRepositoryProvider.get(), storageRepositoryProvider.get());
  }

  public static ExecuteBackupUseCase_Factory create(
      Provider<ShellRepository> shellRepositoryProvider,
      Provider<StorageRepository> storageRepositoryProvider) {
    return new ExecuteBackupUseCase_Factory(shellRepositoryProvider, storageRepositoryProvider);
  }

  public static ExecuteBackupUseCase newInstance(ShellRepository shellRepository,
      StorageRepository storageRepository) {
    return new ExecuteBackupUseCase(shellRepository, storageRepository);
  }
}
