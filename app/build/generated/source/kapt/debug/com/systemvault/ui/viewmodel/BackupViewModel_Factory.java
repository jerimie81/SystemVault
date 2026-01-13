package com.systemvault.ui.viewmodel;

import com.systemvault.data.preferences.PreferencesRepository;
import com.systemvault.data.repository.StorageRepository;
import com.systemvault.domain.usecase.ExtractScriptUseCase;
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
public final class BackupViewModel_Factory implements Factory<BackupViewModel> {
  private final Provider<ExtractScriptUseCase> extractScriptUseCaseProvider;

  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  private final Provider<StorageRepository> storageRepositoryProvider;

  public BackupViewModel_Factory(Provider<ExtractScriptUseCase> extractScriptUseCaseProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<StorageRepository> storageRepositoryProvider) {
    this.extractScriptUseCaseProvider = extractScriptUseCaseProvider;
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
    this.storageRepositoryProvider = storageRepositoryProvider;
  }

  @Override
  public BackupViewModel get() {
    return newInstance(extractScriptUseCaseProvider.get(), preferencesRepositoryProvider.get(), storageRepositoryProvider.get());
  }

  public static BackupViewModel_Factory create(
      Provider<ExtractScriptUseCase> extractScriptUseCaseProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider,
      Provider<StorageRepository> storageRepositoryProvider) {
    return new BackupViewModel_Factory(extractScriptUseCaseProvider, preferencesRepositoryProvider, storageRepositoryProvider);
  }

  public static BackupViewModel newInstance(ExtractScriptUseCase extractScriptUseCase,
      PreferencesRepository preferencesRepository, StorageRepository storageRepository) {
    return new BackupViewModel(extractScriptUseCase, preferencesRepository, storageRepository);
  }
}
