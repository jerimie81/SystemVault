package com.systemvault.data.repository;

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
public final class ShellRepository_Factory implements Factory<ShellRepository> {
  private final Provider<ScriptManager> scriptManagerProvider;

  private final Provider<ShellExecutor> shellExecutorProvider;

  public ShellRepository_Factory(Provider<ScriptManager> scriptManagerProvider,
      Provider<ShellExecutor> shellExecutorProvider) {
    this.scriptManagerProvider = scriptManagerProvider;
    this.shellExecutorProvider = shellExecutorProvider;
  }

  @Override
  public ShellRepository get() {
    return newInstance(scriptManagerProvider.get(), shellExecutorProvider.get());
  }

  public static ShellRepository_Factory create(Provider<ScriptManager> scriptManagerProvider,
      Provider<ShellExecutor> shellExecutorProvider) {
    return new ShellRepository_Factory(scriptManagerProvider, shellExecutorProvider);
  }

  public static ShellRepository newInstance(ScriptManager scriptManager,
      ShellExecutor shellExecutor) {
    return new ShellRepository(scriptManager, shellExecutor);
  }
}
