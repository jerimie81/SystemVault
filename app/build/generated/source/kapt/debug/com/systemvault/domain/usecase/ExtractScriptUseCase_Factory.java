package com.systemvault.domain.usecase;

import com.systemvault.data.repository.ShellRepository;
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
public final class ExtractScriptUseCase_Factory implements Factory<ExtractScriptUseCase> {
  private final Provider<ShellRepository> shellRepositoryProvider;

  public ExtractScriptUseCase_Factory(Provider<ShellRepository> shellRepositoryProvider) {
    this.shellRepositoryProvider = shellRepositoryProvider;
  }

  @Override
  public ExtractScriptUseCase get() {
    return newInstance(shellRepositoryProvider.get());
  }

  public static ExtractScriptUseCase_Factory create(
      Provider<ShellRepository> shellRepositoryProvider) {
    return new ExtractScriptUseCase_Factory(shellRepositoryProvider);
  }

  public static ExtractScriptUseCase newInstance(ShellRepository shellRepository) {
    return new ExtractScriptUseCase(shellRepository);
  }
}
