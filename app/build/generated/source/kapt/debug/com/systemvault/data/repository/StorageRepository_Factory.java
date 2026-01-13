package com.systemvault.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class StorageRepository_Factory implements Factory<StorageRepository> {
  @Override
  public StorageRepository get() {
    return newInstance();
  }

  public static StorageRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static StorageRepository newInstance() {
    return new StorageRepository();
  }

  private static final class InstanceHolder {
    private static final StorageRepository_Factory INSTANCE = new StorageRepository_Factory();
  }
}
