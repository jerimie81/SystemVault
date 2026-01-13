package com.systemvault.di;

import com.systemvault.data.repository.StorageRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideStorageRepositoryFactory implements Factory<StorageRepository> {
  @Override
  public StorageRepository get() {
    return provideStorageRepository();
  }

  public static AppModule_ProvideStorageRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static StorageRepository provideStorageRepository() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideStorageRepository());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideStorageRepositoryFactory INSTANCE = new AppModule_ProvideStorageRepositoryFactory();
  }
}
