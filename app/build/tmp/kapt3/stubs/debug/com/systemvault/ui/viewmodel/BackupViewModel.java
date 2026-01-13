package com.systemvault.ui.viewmodel;

import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.ViewModel;
import com.systemvault.data.BackupEventBus;
import com.systemvault.data.preferences.PreferencesRepository;
import com.systemvault.data.repository.StorageRepository;
import com.systemvault.domain.usecase.ExtractScriptUseCase;
import com.systemvault.service.BackupService;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.flow.StateFlow;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lcom/systemvault/ui/viewmodel/BackupViewModel;", "Landroidx/lifecycle/ViewModel;", "extractScriptUseCase", "Lcom/systemvault/domain/usecase/ExtractScriptUseCase;", "preferencesRepository", "Lcom/systemvault/data/preferences/PreferencesRepository;", "storageRepository", "Lcom/systemvault/data/repository/StorageRepository;", "(Lcom/systemvault/domain/usecase/ExtractScriptUseCase;Lcom/systemvault/data/preferences/PreferencesRepository;Lcom/systemvault/data/repository/StorageRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/systemvault/ui/viewmodel/BackupUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "formattedNow", "", "initialize", "", "onBackupClicked", "context", "Landroid/content/Context;", "backupPath", "onExcludeCacheChanged", "enabled", "", "onExcludeMediaChanged", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class BackupViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.systemvault.domain.usecase.ExtractScriptUseCase extractScriptUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.systemvault.data.preferences.PreferencesRepository preferencesRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.systemvault.data.repository.StorageRepository storageRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.systemvault.ui.viewmodel.BackupUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.systemvault.ui.viewmodel.BackupUiState> uiState = null;
    
    @javax.inject.Inject()
    public BackupViewModel(@org.jetbrains.annotations.NotNull()
    com.systemvault.domain.usecase.ExtractScriptUseCase extractScriptUseCase, @org.jetbrains.annotations.NotNull()
    com.systemvault.data.preferences.PreferencesRepository preferencesRepository, @org.jetbrains.annotations.NotNull()
    com.systemvault.data.repository.StorageRepository storageRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.systemvault.ui.viewmodel.BackupUiState> getUiState() {
        return null;
    }
    
    public final void initialize() {
    }
    
    public final void onExcludeMediaChanged(boolean enabled) {
    }
    
    public final void onExcludeCacheChanged(boolean enabled) {
    }
    
    public final void onBackupClicked(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String backupPath) {
    }
    
    private final java.lang.String formattedNow() {
        return null;
    }
}