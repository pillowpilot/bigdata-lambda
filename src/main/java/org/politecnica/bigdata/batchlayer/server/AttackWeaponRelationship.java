/**
 * Autogenerated by Thrift Compiler (0.11.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.politecnica.bigdata.batchlayer.server;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.11.0)", date = "2018-10-02")
public class AttackWeaponRelationship {

  public interface Iface {

    public void setRelationship(long attack_id, long weapon_id) throws org.apache.thrift.TException;

  }

  public interface AsyncIface {

    public void setRelationship(long attack_id, long weapon_id, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler) throws org.apache.thrift.TException;

  }

  public static class Client extends org.apache.thrift.TServiceClient implements Iface {
    public static class Factory implements org.apache.thrift.TServiceClientFactory<Client> {
      public Factory() {}
      public Client getClient(org.apache.thrift.protocol.TProtocol prot) {
        return new Client(prot);
      }
      public Client getClient(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
        return new Client(iprot, oprot);
      }
    }

    public Client(org.apache.thrift.protocol.TProtocol prot)
    {
      super(prot, prot);
    }

    public Client(org.apache.thrift.protocol.TProtocol iprot, org.apache.thrift.protocol.TProtocol oprot) {
      super(iprot, oprot);
    }

    public void setRelationship(long attack_id, long weapon_id) throws org.apache.thrift.TException
    {
      send_setRelationship(attack_id, weapon_id);
      recv_setRelationship();
    }

    public void send_setRelationship(long attack_id, long weapon_id) throws org.apache.thrift.TException
    {
      setRelationship_args args = new setRelationship_args();
      args.setAttack_id(attack_id);
      args.setWeapon_id(weapon_id);
      sendBase("setRelationship", args);
    }

    public void recv_setRelationship() throws org.apache.thrift.TException
    {
      setRelationship_result result = new setRelationship_result();
      receiveBase(result, "setRelationship");
      return;
    }

  }
  public static class AsyncClient extends org.apache.thrift.async.TAsyncClient implements AsyncIface {
    public static class Factory implements org.apache.thrift.async.TAsyncClientFactory<AsyncClient> {
      private org.apache.thrift.async.TAsyncClientManager clientManager;
      private org.apache.thrift.protocol.TProtocolFactory protocolFactory;
      public Factory(org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.protocol.TProtocolFactory protocolFactory) {
        this.clientManager = clientManager;
        this.protocolFactory = protocolFactory;
      }
      public AsyncClient getAsyncClient(org.apache.thrift.transport.TNonblockingTransport transport) {
        return new AsyncClient(protocolFactory, clientManager, transport);
      }
    }

    public AsyncClient(org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.async.TAsyncClientManager clientManager, org.apache.thrift.transport.TNonblockingTransport transport) {
      super(protocolFactory, clientManager, transport);
    }

    public void setRelationship(long attack_id, long weapon_id, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler) throws org.apache.thrift.TException {
      checkReady();
      setRelationship_call method_call = new setRelationship_call(attack_id, weapon_id, resultHandler, this, ___protocolFactory, ___transport);
      this.___currentMethod = method_call;
      ___manager.call(method_call);
    }

    public static class setRelationship_call extends org.apache.thrift.async.TAsyncMethodCall<Void> {
      private long attack_id;
      private long weapon_id;
      public setRelationship_call(long attack_id, long weapon_id, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler, org.apache.thrift.async.TAsyncClient client, org.apache.thrift.protocol.TProtocolFactory protocolFactory, org.apache.thrift.transport.TNonblockingTransport transport) throws org.apache.thrift.TException {
        super(client, protocolFactory, transport, resultHandler, false);
        this.attack_id = attack_id;
        this.weapon_id = weapon_id;
      }

      public void write_args(org.apache.thrift.protocol.TProtocol prot) throws org.apache.thrift.TException {
        prot.writeMessageBegin(new org.apache.thrift.protocol.TMessage("setRelationship", org.apache.thrift.protocol.TMessageType.CALL, 0));
        setRelationship_args args = new setRelationship_args();
        args.setAttack_id(attack_id);
        args.setWeapon_id(weapon_id);
        args.write(prot);
        prot.writeMessageEnd();
      }

      public Void getResult() throws org.apache.thrift.TException {
        if (getState() != org.apache.thrift.async.TAsyncMethodCall.State.RESPONSE_READ) {
          throw new java.lang.IllegalStateException("Method call not finished!");
        }
        org.apache.thrift.transport.TMemoryInputTransport memoryTransport = new org.apache.thrift.transport.TMemoryInputTransport(getFrameBuffer().array());
        org.apache.thrift.protocol.TProtocol prot = client.getProtocolFactory().getProtocol(memoryTransport);
        return null;
      }
    }

  }

  public static class Processor<I extends Iface> extends org.apache.thrift.TBaseProcessor<I> implements org.apache.thrift.TProcessor {
    private static final org.slf4j.Logger _LOGGER = org.slf4j.LoggerFactory.getLogger(Processor.class.getName());
    public Processor(I iface) {
      super(iface, getProcessMap(new java.util.HashMap<java.lang.String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>>()));
    }

    protected Processor(I iface, java.util.Map<java.lang.String, org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends Iface> java.util.Map<java.lang.String,  org.apache.thrift.ProcessFunction<I, ? extends org.apache.thrift.TBase>> getProcessMap(java.util.Map<java.lang.String, org.apache.thrift.ProcessFunction<I, ? extends  org.apache.thrift.TBase>> processMap) {
      processMap.put("setRelationship", new setRelationship());
      return processMap;
    }

    public static class setRelationship<I extends Iface> extends org.apache.thrift.ProcessFunction<I, setRelationship_args> {
      public setRelationship() {
        super("setRelationship");
      }

      public setRelationship_args getEmptyArgsInstance() {
        return new setRelationship_args();
      }

      protected boolean isOneway() {
        return false;
      }

      @Override
      protected boolean handleRuntimeExceptions() {
        return false;
      }

      public setRelationship_result getResult(I iface, setRelationship_args args) throws org.apache.thrift.TException {
        setRelationship_result result = new setRelationship_result();
        iface.setRelationship(args.attack_id, args.weapon_id);
        return result;
      }
    }

  }

  public static class AsyncProcessor<I extends AsyncIface> extends org.apache.thrift.TBaseAsyncProcessor<I> {
    private static final org.slf4j.Logger _LOGGER = org.slf4j.LoggerFactory.getLogger(AsyncProcessor.class.getName());
    public AsyncProcessor(I iface) {
      super(iface, getProcessMap(new java.util.HashMap<java.lang.String, org.apache.thrift.AsyncProcessFunction<I, ? extends org.apache.thrift.TBase, ?>>()));
    }

    protected AsyncProcessor(I iface, java.util.Map<java.lang.String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      super(iface, getProcessMap(processMap));
    }

    private static <I extends AsyncIface> java.util.Map<java.lang.String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase,?>> getProcessMap(java.util.Map<java.lang.String,  org.apache.thrift.AsyncProcessFunction<I, ? extends  org.apache.thrift.TBase, ?>> processMap) {
      processMap.put("setRelationship", new setRelationship());
      return processMap;
    }

    public static class setRelationship<I extends AsyncIface> extends org.apache.thrift.AsyncProcessFunction<I, setRelationship_args, Void> {
      public setRelationship() {
        super("setRelationship");
      }

      public setRelationship_args getEmptyArgsInstance() {
        return new setRelationship_args();
      }

      public org.apache.thrift.async.AsyncMethodCallback<Void> getResultHandler(final org.apache.thrift.server.AbstractNonblockingServer.AsyncFrameBuffer fb, final int seqid) {
        final org.apache.thrift.AsyncProcessFunction fcall = this;
        return new org.apache.thrift.async.AsyncMethodCallback<Void>() { 
          public void onComplete(Void o) {
            setRelationship_result result = new setRelationship_result();
            try {
              fcall.sendResponse(fb, result, org.apache.thrift.protocol.TMessageType.REPLY,seqid);
            } catch (org.apache.thrift.transport.TTransportException e) {
              _LOGGER.error("TTransportException writing to internal frame buffer", e);
              fb.close();
            } catch (java.lang.Exception e) {
              _LOGGER.error("Exception writing to internal frame buffer", e);
              onError(e);
            }
          }
          public void onError(java.lang.Exception e) {
            byte msgType = org.apache.thrift.protocol.TMessageType.REPLY;
            org.apache.thrift.TSerializable msg;
            setRelationship_result result = new setRelationship_result();
            if (e instanceof org.apache.thrift.transport.TTransportException) {
              _LOGGER.error("TTransportException inside handler", e);
              fb.close();
              return;
            } else if (e instanceof org.apache.thrift.TApplicationException) {
              _LOGGER.error("TApplicationException inside handler", e);
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = (org.apache.thrift.TApplicationException)e;
            } else {
              _LOGGER.error("Exception inside handler", e);
              msgType = org.apache.thrift.protocol.TMessageType.EXCEPTION;
              msg = new org.apache.thrift.TApplicationException(org.apache.thrift.TApplicationException.INTERNAL_ERROR, e.getMessage());
            }
            try {
              fcall.sendResponse(fb,msg,msgType,seqid);
            } catch (java.lang.Exception ex) {
              _LOGGER.error("Exception writing to internal frame buffer", ex);
              fb.close();
            }
          }
        };
      }

      protected boolean isOneway() {
        return false;
      }

      public void start(I iface, setRelationship_args args, org.apache.thrift.async.AsyncMethodCallback<Void> resultHandler) throws org.apache.thrift.TException {
        iface.setRelationship(args.attack_id, args.weapon_id,resultHandler);
      }
    }

  }

  public static class setRelationship_args implements org.apache.thrift.TBase<setRelationship_args, setRelationship_args._Fields>, java.io.Serializable, Cloneable, Comparable<setRelationship_args>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("setRelationship_args");

    private static final org.apache.thrift.protocol.TField ATTACK_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("attack_id", org.apache.thrift.protocol.TType.I64, (short)1);
    private static final org.apache.thrift.protocol.TField WEAPON_ID_FIELD_DESC = new org.apache.thrift.protocol.TField("weapon_id", org.apache.thrift.protocol.TType.I64, (short)2);

    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new setRelationship_argsStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new setRelationship_argsTupleSchemeFactory();

    public long attack_id; // required
    public long weapon_id; // required

    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
      ATTACK_ID((short)1, "attack_id"),
      WEAPON_ID((short)2, "weapon_id");

      private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

      static {
        for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          case 1: // ATTACK_ID
            return ATTACK_ID;
          case 2: // WEAPON_ID
            return WEAPON_ID;
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(java.lang.String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final java.lang.String _fieldName;

      _Fields(short thriftId, java.lang.String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public java.lang.String getFieldName() {
        return _fieldName;
      }
    }

    // isset id assignments
    private static final int __ATTACK_ID_ISSET_ID = 0;
    private static final int __WEAPON_ID_ISSET_ID = 1;
    private byte __isset_bitfield = 0;
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      tmpMap.put(_Fields.ATTACK_ID, new org.apache.thrift.meta_data.FieldMetaData("attack_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
      tmpMap.put(_Fields.WEAPON_ID, new org.apache.thrift.meta_data.FieldMetaData("weapon_id", org.apache.thrift.TFieldRequirementType.DEFAULT, 
          new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
      metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(setRelationship_args.class, metaDataMap);
    }

    public setRelationship_args() {
    }

    public setRelationship_args(
      long attack_id,
      long weapon_id)
    {
      this();
      this.attack_id = attack_id;
      setAttack_idIsSet(true);
      this.weapon_id = weapon_id;
      setWeapon_idIsSet(true);
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public setRelationship_args(setRelationship_args other) {
      __isset_bitfield = other.__isset_bitfield;
      this.attack_id = other.attack_id;
      this.weapon_id = other.weapon_id;
    }

    public setRelationship_args deepCopy() {
      return new setRelationship_args(this);
    }

    @Override
    public void clear() {
      setAttack_idIsSet(false);
      this.attack_id = 0;
      setWeapon_idIsSet(false);
      this.weapon_id = 0;
    }

    public long getAttack_id() {
      return this.attack_id;
    }

    public setRelationship_args setAttack_id(long attack_id) {
      this.attack_id = attack_id;
      setAttack_idIsSet(true);
      return this;
    }

    public void unsetAttack_id() {
      __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __ATTACK_ID_ISSET_ID);
    }

    /** Returns true if field attack_id is set (has been assigned a value) and false otherwise */
    public boolean isSetAttack_id() {
      return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __ATTACK_ID_ISSET_ID);
    }

    public void setAttack_idIsSet(boolean value) {
      __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __ATTACK_ID_ISSET_ID, value);
    }

    public long getWeapon_id() {
      return this.weapon_id;
    }

    public setRelationship_args setWeapon_id(long weapon_id) {
      this.weapon_id = weapon_id;
      setWeapon_idIsSet(true);
      return this;
    }

    public void unsetWeapon_id() {
      __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __WEAPON_ID_ISSET_ID);
    }

    /** Returns true if field weapon_id is set (has been assigned a value) and false otherwise */
    public boolean isSetWeapon_id() {
      return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __WEAPON_ID_ISSET_ID);
    }

    public void setWeapon_idIsSet(boolean value) {
      __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __WEAPON_ID_ISSET_ID, value);
    }

    public void setFieldValue(_Fields field, java.lang.Object value) {
      switch (field) {
      case ATTACK_ID:
        if (value == null) {
          unsetAttack_id();
        } else {
          setAttack_id((java.lang.Long)value);
        }
        break;

      case WEAPON_ID:
        if (value == null) {
          unsetWeapon_id();
        } else {
          setWeapon_id((java.lang.Long)value);
        }
        break;

      }
    }

    public java.lang.Object getFieldValue(_Fields field) {
      switch (field) {
      case ATTACK_ID:
        return getAttack_id();

      case WEAPON_ID:
        return getWeapon_id();

      }
      throw new java.lang.IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new java.lang.IllegalArgumentException();
      }

      switch (field) {
      case ATTACK_ID:
        return isSetAttack_id();
      case WEAPON_ID:
        return isSetWeapon_id();
      }
      throw new java.lang.IllegalStateException();
    }

    @Override
    public boolean equals(java.lang.Object that) {
      if (that == null)
        return false;
      if (that instanceof setRelationship_args)
        return this.equals((setRelationship_args)that);
      return false;
    }

    public boolean equals(setRelationship_args that) {
      if (that == null)
        return false;
      if (this == that)
        return true;

      boolean this_present_attack_id = true;
      boolean that_present_attack_id = true;
      if (this_present_attack_id || that_present_attack_id) {
        if (!(this_present_attack_id && that_present_attack_id))
          return false;
        if (this.attack_id != that.attack_id)
          return false;
      }

      boolean this_present_weapon_id = true;
      boolean that_present_weapon_id = true;
      if (this_present_weapon_id || that_present_weapon_id) {
        if (!(this_present_weapon_id && that_present_weapon_id))
          return false;
        if (this.weapon_id != that.weapon_id)
          return false;
      }

      return true;
    }

    @Override
    public int hashCode() {
      int hashCode = 1;

      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(attack_id);

      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(weapon_id);

      return hashCode;
    }

    @Override
    public int compareTo(setRelationship_args other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      lastComparison = java.lang.Boolean.valueOf(isSetAttack_id()).compareTo(other.isSetAttack_id());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetAttack_id()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.attack_id, other.attack_id);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      lastComparison = java.lang.Boolean.valueOf(isSetWeapon_id()).compareTo(other.isSetWeapon_id());
      if (lastComparison != 0) {
        return lastComparison;
      }
      if (isSetWeapon_id()) {
        lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.weapon_id, other.weapon_id);
        if (lastComparison != 0) {
          return lastComparison;
        }
      }
      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      scheme(iprot).read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      scheme(oprot).write(oprot, this);
    }

    @Override
    public java.lang.String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder("setRelationship_args(");
      boolean first = true;

      sb.append("attack_id:");
      sb.append(this.attack_id);
      first = false;
      if (!first) sb.append(", ");
      sb.append("weapon_id:");
      sb.append(this.weapon_id);
      first = false;
      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
      try {
        // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
        __isset_bitfield = 0;
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class setRelationship_argsStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
      public setRelationship_argsStandardScheme getScheme() {
        return new setRelationship_argsStandardScheme();
      }
    }

    private static class setRelationship_argsStandardScheme extends org.apache.thrift.scheme.StandardScheme<setRelationship_args> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, setRelationship_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            case 1: // ATTACK_ID
              if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
                struct.attack_id = iprot.readI64();
                struct.setAttack_idIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            case 2: // WEAPON_ID
              if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
                struct.weapon_id = iprot.readI64();
                struct.setWeapon_idIsSet(true);
              } else { 
                org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
              }
              break;
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, setRelationship_args struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        oprot.writeFieldBegin(ATTACK_ID_FIELD_DESC);
        oprot.writeI64(struct.attack_id);
        oprot.writeFieldEnd();
        oprot.writeFieldBegin(WEAPON_ID_FIELD_DESC);
        oprot.writeI64(struct.weapon_id);
        oprot.writeFieldEnd();
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class setRelationship_argsTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
      public setRelationship_argsTupleScheme getScheme() {
        return new setRelationship_argsTupleScheme();
      }
    }

    private static class setRelationship_argsTupleScheme extends org.apache.thrift.scheme.TupleScheme<setRelationship_args> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, setRelationship_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        java.util.BitSet optionals = new java.util.BitSet();
        if (struct.isSetAttack_id()) {
          optionals.set(0);
        }
        if (struct.isSetWeapon_id()) {
          optionals.set(1);
        }
        oprot.writeBitSet(optionals, 2);
        if (struct.isSetAttack_id()) {
          oprot.writeI64(struct.attack_id);
        }
        if (struct.isSetWeapon_id()) {
          oprot.writeI64(struct.weapon_id);
        }
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, setRelationship_args struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
        java.util.BitSet incoming = iprot.readBitSet(2);
        if (incoming.get(0)) {
          struct.attack_id = iprot.readI64();
          struct.setAttack_idIsSet(true);
        }
        if (incoming.get(1)) {
          struct.weapon_id = iprot.readI64();
          struct.setWeapon_idIsSet(true);
        }
      }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
      return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
  }

  public static class setRelationship_result implements org.apache.thrift.TBase<setRelationship_result, setRelationship_result._Fields>, java.io.Serializable, Cloneable, Comparable<setRelationship_result>   {
    private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("setRelationship_result");


    private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new setRelationship_resultStandardSchemeFactory();
    private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new setRelationship_resultTupleSchemeFactory();


    /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
    public enum _Fields implements org.apache.thrift.TFieldIdEnum {
;

      private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

      static {
        for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
          byName.put(field.getFieldName(), field);
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, or null if its not found.
       */
      public static _Fields findByThriftId(int fieldId) {
        switch(fieldId) {
          default:
            return null;
        }
      }

      /**
       * Find the _Fields constant that matches fieldId, throwing an exception
       * if it is not found.
       */
      public static _Fields findByThriftIdOrThrow(int fieldId) {
        _Fields fields = findByThriftId(fieldId);
        if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
        return fields;
      }

      /**
       * Find the _Fields constant that matches name, or null if its not found.
       */
      public static _Fields findByName(java.lang.String name) {
        return byName.get(name);
      }

      private final short _thriftId;
      private final java.lang.String _fieldName;

      _Fields(short thriftId, java.lang.String fieldName) {
        _thriftId = thriftId;
        _fieldName = fieldName;
      }

      public short getThriftFieldId() {
        return _thriftId;
      }

      public java.lang.String getFieldName() {
        return _fieldName;
      }
    }
    public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
    static {
      java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
      metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
      org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(setRelationship_result.class, metaDataMap);
    }

    public setRelationship_result() {
    }

    /**
     * Performs a deep copy on <i>other</i>.
     */
    public setRelationship_result(setRelationship_result other) {
    }

    public setRelationship_result deepCopy() {
      return new setRelationship_result(this);
    }

    @Override
    public void clear() {
    }

    public void setFieldValue(_Fields field, java.lang.Object value) {
      switch (field) {
      }
    }

    public java.lang.Object getFieldValue(_Fields field) {
      switch (field) {
      }
      throw new java.lang.IllegalStateException();
    }

    /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
    public boolean isSet(_Fields field) {
      if (field == null) {
        throw new java.lang.IllegalArgumentException();
      }

      switch (field) {
      }
      throw new java.lang.IllegalStateException();
    }

    @Override
    public boolean equals(java.lang.Object that) {
      if (that == null)
        return false;
      if (that instanceof setRelationship_result)
        return this.equals((setRelationship_result)that);
      return false;
    }

    public boolean equals(setRelationship_result that) {
      if (that == null)
        return false;
      if (this == that)
        return true;

      return true;
    }

    @Override
    public int hashCode() {
      int hashCode = 1;

      return hashCode;
    }

    @Override
    public int compareTo(setRelationship_result other) {
      if (!getClass().equals(other.getClass())) {
        return getClass().getName().compareTo(other.getClass().getName());
      }

      int lastComparison = 0;

      return 0;
    }

    public _Fields fieldForId(int fieldId) {
      return _Fields.findByThriftId(fieldId);
    }

    public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
      scheme(iprot).read(iprot, this);
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
      scheme(oprot).write(oprot, this);
      }

    @Override
    public java.lang.String toString() {
      java.lang.StringBuilder sb = new java.lang.StringBuilder("setRelationship_result(");
      boolean first = true;

      sb.append(")");
      return sb.toString();
    }

    public void validate() throws org.apache.thrift.TException {
      // check for required fields
      // check for sub-struct validity
    }

    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
      try {
        write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
      try {
        read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
      } catch (org.apache.thrift.TException te) {
        throw new java.io.IOException(te);
      }
    }

    private static class setRelationship_resultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
      public setRelationship_resultStandardScheme getScheme() {
        return new setRelationship_resultStandardScheme();
      }
    }

    private static class setRelationship_resultStandardScheme extends org.apache.thrift.scheme.StandardScheme<setRelationship_result> {

      public void read(org.apache.thrift.protocol.TProtocol iprot, setRelationship_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TField schemeField;
        iprot.readStructBegin();
        while (true)
        {
          schemeField = iprot.readFieldBegin();
          if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
            break;
          }
          switch (schemeField.id) {
            default:
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
          }
          iprot.readFieldEnd();
        }
        iprot.readStructEnd();

        // check for required fields of primitive type, which can't be checked in the validate method
        struct.validate();
      }

      public void write(org.apache.thrift.protocol.TProtocol oprot, setRelationship_result struct) throws org.apache.thrift.TException {
        struct.validate();

        oprot.writeStructBegin(STRUCT_DESC);
        oprot.writeFieldStop();
        oprot.writeStructEnd();
      }

    }

    private static class setRelationship_resultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
      public setRelationship_resultTupleScheme getScheme() {
        return new setRelationship_resultTupleScheme();
      }
    }

    private static class setRelationship_resultTupleScheme extends org.apache.thrift.scheme.TupleScheme<setRelationship_result> {

      @Override
      public void write(org.apache.thrift.protocol.TProtocol prot, setRelationship_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      }

      @Override
      public void read(org.apache.thrift.protocol.TProtocol prot, setRelationship_result struct) throws org.apache.thrift.TException {
        org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      }
    }

    private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
      return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
    }
  }

}