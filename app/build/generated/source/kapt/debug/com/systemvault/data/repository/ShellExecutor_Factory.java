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
public final class ShellExecutor_Factory implements Factory<ShellExecutor> {
  @Override
  public ShellExecutor get() {
    return newInstance();
  }

  public static ShellExecutor_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ShellExecutor newInstance() {
    return new ShellExecutor();
  }

  private static final class InstanceHolder {
    private static final ShellExecutor_Factory INSTANCE = new ShellExecutor_Factory();
  }
}
