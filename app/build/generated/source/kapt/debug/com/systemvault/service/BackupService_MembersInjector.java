package com.systemvault.service;

import com.systemvault.domain.usecase.ExecuteBackupUseCase;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class BackupService_MembersInjector implements MembersInjector<BackupService> {
  private final Provider<ExecuteBackupUseCase> executeBackupUseCaseProvider;

  public BackupService_MembersInjector(
      Provider<ExecuteBackupUseCase> executeBackupUseCaseProvider) {
    this.executeBackupUseCaseProvider = executeBackupUseCaseProvider;
  }

  public static MembersInjector<BackupService> create(
      Provider<ExecuteBackupUseCase> executeBackupUseCaseProvider) {
    return new BackupService_MembersInjector(executeBackupUseCaseProvider);
  }

  @Override
  public void injectMembers(BackupService instance) {
    injectExecuteBackupUseCase(instance, executeBackupUseCaseProvider.get());
  }

  @InjectedFieldSignature("com.systemvault.service.BackupService.executeBackupUseCase")
  public static void injectExecuteBackupUseCase(BackupService instance,
      ExecuteBackupUseCase executeBackupUseCase) {
    instance.executeBackupUseCase = executeBackupUseCase;
  }
}
