package com.systemvault.data.repository;

import android.content.Context;
import com.systemvault.data.preferences.PreferencesRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class ScriptManager_Factory implements Factory<ScriptManager> {
  private final Provider<Context> contextProvider;

  private final Provider<PreferencesRepository> preferencesRepositoryProvider;

  public ScriptManager_Factory(Provider<Context> contextProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    this.contextProvider = contextProvider;
    this.preferencesRepositoryProvider = preferencesRepositoryProvider;
  }

  @Override
  public ScriptManager get() {
    return newInstance(contextProvider.get(), preferencesRepositoryProvider.get());
  }

  public static ScriptManager_Factory create(Provider<Context> contextProvider,
      Provider<PreferencesRepository> preferencesRepositoryProvider) {
    return new ScriptManager_Factory(contextProvider, preferencesRepositoryProvider);
  }

  public static ScriptManager newInstance(Context context,
      PreferencesRepository preferencesRepository) {
    return new ScriptManager(context, preferencesRepository);
  }
}
