// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: customer.proto

package de.hsw.customer;

public final class CustomerProtos {
  private CustomerProtos() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_tutorial_Customer_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_tutorial_Customer_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\016customer.proto\022\010tutorial\"\323\001\n\010Customer\022" +
      "\017\n\002id\030\001 \001(\005H\000\210\001\001\022\021\n\004name\030\002 \001(\tH\001\210\001\001\022\022\n\005e" +
      "mail\030\003 \001(\tH\002\210\001\001\0222\n\004type\030\004 \001(\0162\037.tutorial" +
      ".Customer.CustomerTypeH\003\210\001\001\"8\n\014CustomerT" +
      "ype\022\013\n\007PRIVATE\020\000\022\014\n\010BUSINESS\020\001\022\r\n\tNONPRO" +
      "FIT\020\002B\005\n\003_idB\007\n\005_nameB\010\n\006_emailB\007\n\005_type" +
      "2C\n\017CustomerService\0220\n\006Search\022\022.tutorial" +
      ".Customer\032\022.tutorial.CustomerB#\n\017de.hsw." +
      "customerB\016CustomerProtosP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_tutorial_Customer_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_tutorial_Customer_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_tutorial_Customer_descriptor,
        new java.lang.String[] { "Id", "Name", "Email", "Type", "Id", "Name", "Email", "Type", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
