/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.diviso.graeshoppe.payment.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Payment extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2835122591468748128L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Payment\",\"namespace\":\"com.diviso.graeshoppe.payment.avro\",\"fields\":[{\"name\":\"ref\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"payee\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"payer\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"targetId\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"paymentType\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"provider\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"amount\",\"type\":\"double\"},{\"name\":\"tax\",\"type\":\"double\"},{\"name\":\"total\",\"type\":\"double\"},{\"name\":\"status\",\"type\":[\"null\",{\"type\":\"string\",\"avro.java.string\":\"String\"}]},{\"name\":\"dateAndTime\",\"type\":\"long\",\"logicalType\":\"date\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Payment> ENCODER =
      new BinaryMessageEncoder<Payment>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Payment> DECODER =
      new BinaryMessageDecoder<Payment>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Payment> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Payment> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Payment>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Payment to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Payment from a ByteBuffer. */
  public static Payment fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String ref;
  @Deprecated public java.lang.String payee;
  @Deprecated public java.lang.String payer;
  @Deprecated public java.lang.String targetId;
  @Deprecated public java.lang.String paymentType;
  @Deprecated public java.lang.String provider;
  @Deprecated public double amount;
  @Deprecated public double tax;
  @Deprecated public double total;
  @Deprecated public java.lang.String status;
  @Deprecated public long dateAndTime;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Payment() {}

  /**
   * All-args constructor.
   * @param ref The new value for ref
   * @param payee The new value for payee
   * @param payer The new value for payer
   * @param targetId The new value for targetId
   * @param paymentType The new value for paymentType
   * @param provider The new value for provider
   * @param amount The new value for amount
   * @param tax The new value for tax
   * @param total The new value for total
   * @param status The new value for status
   * @param dateAndTime The new value for dateAndTime
   */
  public Payment(java.lang.String ref, java.lang.String payee, java.lang.String payer, java.lang.String targetId, java.lang.String paymentType, java.lang.String provider, java.lang.Double amount, java.lang.Double tax, java.lang.Double total, java.lang.String status, java.lang.Long dateAndTime) {
    this.ref = ref;
    this.payee = payee;
    this.payer = payer;
    this.targetId = targetId;
    this.paymentType = paymentType;
    this.provider = provider;
    this.amount = amount;
    this.tax = tax;
    this.total = total;
    this.status = status;
    this.dateAndTime = dateAndTime;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return ref;
    case 1: return payee;
    case 2: return payer;
    case 3: return targetId;
    case 4: return paymentType;
    case 5: return provider;
    case 6: return amount;
    case 7: return tax;
    case 8: return total;
    case 9: return status;
    case 10: return dateAndTime;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: ref = (java.lang.String)value$; break;
    case 1: payee = (java.lang.String)value$; break;
    case 2: payer = (java.lang.String)value$; break;
    case 3: targetId = (java.lang.String)value$; break;
    case 4: paymentType = (java.lang.String)value$; break;
    case 5: provider = (java.lang.String)value$; break;
    case 6: amount = (java.lang.Double)value$; break;
    case 7: tax = (java.lang.Double)value$; break;
    case 8: total = (java.lang.Double)value$; break;
    case 9: status = (java.lang.String)value$; break;
    case 10: dateAndTime = (java.lang.Long)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'ref' field.
   * @return The value of the 'ref' field.
   */
  public java.lang.String getRef() {
    return ref;
  }

  /**
   * Sets the value of the 'ref' field.
   * @param value the value to set.
   */
  public void setRef(java.lang.String value) {
    this.ref = value;
  }

  /**
   * Gets the value of the 'payee' field.
   * @return The value of the 'payee' field.
   */
  public java.lang.String getPayee() {
    return payee;
  }

  /**
   * Sets the value of the 'payee' field.
   * @param value the value to set.
   */
  public void setPayee(java.lang.String value) {
    this.payee = value;
  }

  /**
   * Gets the value of the 'payer' field.
   * @return The value of the 'payer' field.
   */
  public java.lang.String getPayer() {
    return payer;
  }

  /**
   * Sets the value of the 'payer' field.
   * @param value the value to set.
   */
  public void setPayer(java.lang.String value) {
    this.payer = value;
  }

  /**
   * Gets the value of the 'targetId' field.
   * @return The value of the 'targetId' field.
   */
  public java.lang.String getTargetId() {
    return targetId;
  }

  /**
   * Sets the value of the 'targetId' field.
   * @param value the value to set.
   */
  public void setTargetId(java.lang.String value) {
    this.targetId = value;
  }

  /**
   * Gets the value of the 'paymentType' field.
   * @return The value of the 'paymentType' field.
   */
  public java.lang.String getPaymentType() {
    return paymentType;
  }

  /**
   * Sets the value of the 'paymentType' field.
   * @param value the value to set.
   */
  public void setPaymentType(java.lang.String value) {
    this.paymentType = value;
  }

  /**
   * Gets the value of the 'provider' field.
   * @return The value of the 'provider' field.
   */
  public java.lang.String getProvider() {
    return provider;
  }

  /**
   * Sets the value of the 'provider' field.
   * @param value the value to set.
   */
  public void setProvider(java.lang.String value) {
    this.provider = value;
  }

  /**
   * Gets the value of the 'amount' field.
   * @return The value of the 'amount' field.
   */
  public java.lang.Double getAmount() {
    return amount;
  }

  /**
   * Sets the value of the 'amount' field.
   * @param value the value to set.
   */
  public void setAmount(java.lang.Double value) {
    this.amount = value;
  }

  /**
   * Gets the value of the 'tax' field.
   * @return The value of the 'tax' field.
   */
  public java.lang.Double getTax() {
    return tax;
  }

  /**
   * Sets the value of the 'tax' field.
   * @param value the value to set.
   */
  public void setTax(java.lang.Double value) {
    this.tax = value;
  }

  /**
   * Gets the value of the 'total' field.
   * @return The value of the 'total' field.
   */
  public java.lang.Double getTotal() {
    return total;
  }

  /**
   * Sets the value of the 'total' field.
   * @param value the value to set.
   */
  public void setTotal(java.lang.Double value) {
    this.total = value;
  }

  /**
   * Gets the value of the 'status' field.
   * @return The value of the 'status' field.
   */
  public java.lang.String getStatus() {
    return status;
  }

  /**
   * Sets the value of the 'status' field.
   * @param value the value to set.
   */
  public void setStatus(java.lang.String value) {
    this.status = value;
  }

  /**
   * Gets the value of the 'dateAndTime' field.
   * @return The value of the 'dateAndTime' field.
   */
  public java.lang.Long getDateAndTime() {
    return dateAndTime;
  }

  /**
   * Sets the value of the 'dateAndTime' field.
   * @param value the value to set.
   */
  public void setDateAndTime(java.lang.Long value) {
    this.dateAndTime = value;
  }

  /**
   * Creates a new Payment RecordBuilder.
   * @return A new Payment RecordBuilder
   */
  public static com.diviso.graeshoppe.payment.avro.Payment.Builder newBuilder() {
    return new com.diviso.graeshoppe.payment.avro.Payment.Builder();
  }

  /**
   * Creates a new Payment RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Payment RecordBuilder
   */
  public static com.diviso.graeshoppe.payment.avro.Payment.Builder newBuilder(com.diviso.graeshoppe.payment.avro.Payment.Builder other) {
    return new com.diviso.graeshoppe.payment.avro.Payment.Builder(other);
  }

  /**
   * Creates a new Payment RecordBuilder by copying an existing Payment instance.
   * @param other The existing instance to copy.
   * @return A new Payment RecordBuilder
   */
  public static com.diviso.graeshoppe.payment.avro.Payment.Builder newBuilder(com.diviso.graeshoppe.payment.avro.Payment other) {
    return new com.diviso.graeshoppe.payment.avro.Payment.Builder(other);
  }

  /**
   * RecordBuilder for Payment instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Payment>
    implements org.apache.avro.data.RecordBuilder<Payment> {

    private java.lang.String ref;
    private java.lang.String payee;
    private java.lang.String payer;
    private java.lang.String targetId;
    private java.lang.String paymentType;
    private java.lang.String provider;
    private double amount;
    private double tax;
    private double total;
    private java.lang.String status;
    private long dateAndTime;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.diviso.graeshoppe.payment.avro.Payment.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.ref)) {
        this.ref = data().deepCopy(fields()[0].schema(), other.ref);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.payee)) {
        this.payee = data().deepCopy(fields()[1].schema(), other.payee);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.payer)) {
        this.payer = data().deepCopy(fields()[2].schema(), other.payer);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.targetId)) {
        this.targetId = data().deepCopy(fields()[3].schema(), other.targetId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.paymentType)) {
        this.paymentType = data().deepCopy(fields()[4].schema(), other.paymentType);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.provider)) {
        this.provider = data().deepCopy(fields()[5].schema(), other.provider);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.amount)) {
        this.amount = data().deepCopy(fields()[6].schema(), other.amount);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.tax)) {
        this.tax = data().deepCopy(fields()[7].schema(), other.tax);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.total)) {
        this.total = data().deepCopy(fields()[8].schema(), other.total);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.status)) {
        this.status = data().deepCopy(fields()[9].schema(), other.status);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.dateAndTime)) {
        this.dateAndTime = data().deepCopy(fields()[10].schema(), other.dateAndTime);
        fieldSetFlags()[10] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Payment instance
     * @param other The existing instance to copy.
     */
    private Builder(com.diviso.graeshoppe.payment.avro.Payment other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.ref)) {
        this.ref = data().deepCopy(fields()[0].schema(), other.ref);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.payee)) {
        this.payee = data().deepCopy(fields()[1].schema(), other.payee);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.payer)) {
        this.payer = data().deepCopy(fields()[2].schema(), other.payer);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.targetId)) {
        this.targetId = data().deepCopy(fields()[3].schema(), other.targetId);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.paymentType)) {
        this.paymentType = data().deepCopy(fields()[4].schema(), other.paymentType);
        fieldSetFlags()[4] = true;
      }
      if (isValidValue(fields()[5], other.provider)) {
        this.provider = data().deepCopy(fields()[5].schema(), other.provider);
        fieldSetFlags()[5] = true;
      }
      if (isValidValue(fields()[6], other.amount)) {
        this.amount = data().deepCopy(fields()[6].schema(), other.amount);
        fieldSetFlags()[6] = true;
      }
      if (isValidValue(fields()[7], other.tax)) {
        this.tax = data().deepCopy(fields()[7].schema(), other.tax);
        fieldSetFlags()[7] = true;
      }
      if (isValidValue(fields()[8], other.total)) {
        this.total = data().deepCopy(fields()[8].schema(), other.total);
        fieldSetFlags()[8] = true;
      }
      if (isValidValue(fields()[9], other.status)) {
        this.status = data().deepCopy(fields()[9].schema(), other.status);
        fieldSetFlags()[9] = true;
      }
      if (isValidValue(fields()[10], other.dateAndTime)) {
        this.dateAndTime = data().deepCopy(fields()[10].schema(), other.dateAndTime);
        fieldSetFlags()[10] = true;
      }
    }

    /**
      * Gets the value of the 'ref' field.
      * @return The value.
      */
    public java.lang.String getRef() {
      return ref;
    }

    /**
      * Sets the value of the 'ref' field.
      * @param value The value of 'ref'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setRef(java.lang.String value) {
      validate(fields()[0], value);
      this.ref = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'ref' field has been set.
      * @return True if the 'ref' field has been set, false otherwise.
      */
    public boolean hasRef() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'ref' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearRef() {
      ref = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'payee' field.
      * @return The value.
      */
    public java.lang.String getPayee() {
      return payee;
    }

    /**
      * Sets the value of the 'payee' field.
      * @param value The value of 'payee'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setPayee(java.lang.String value) {
      validate(fields()[1], value);
      this.payee = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'payee' field has been set.
      * @return True if the 'payee' field has been set, false otherwise.
      */
    public boolean hasPayee() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'payee' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearPayee() {
      payee = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'payer' field.
      * @return The value.
      */
    public java.lang.String getPayer() {
      return payer;
    }

    /**
      * Sets the value of the 'payer' field.
      * @param value The value of 'payer'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setPayer(java.lang.String value) {
      validate(fields()[2], value);
      this.payer = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'payer' field has been set.
      * @return True if the 'payer' field has been set, false otherwise.
      */
    public boolean hasPayer() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'payer' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearPayer() {
      payer = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'targetId' field.
      * @return The value.
      */
    public java.lang.String getTargetId() {
      return targetId;
    }

    /**
      * Sets the value of the 'targetId' field.
      * @param value The value of 'targetId'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setTargetId(java.lang.String value) {
      validate(fields()[3], value);
      this.targetId = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'targetId' field has been set.
      * @return True if the 'targetId' field has been set, false otherwise.
      */
    public boolean hasTargetId() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'targetId' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearTargetId() {
      targetId = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'paymentType' field.
      * @return The value.
      */
    public java.lang.String getPaymentType() {
      return paymentType;
    }

    /**
      * Sets the value of the 'paymentType' field.
      * @param value The value of 'paymentType'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setPaymentType(java.lang.String value) {
      validate(fields()[4], value);
      this.paymentType = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'paymentType' field has been set.
      * @return True if the 'paymentType' field has been set, false otherwise.
      */
    public boolean hasPaymentType() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'paymentType' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearPaymentType() {
      paymentType = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    /**
      * Gets the value of the 'provider' field.
      * @return The value.
      */
    public java.lang.String getProvider() {
      return provider;
    }

    /**
      * Sets the value of the 'provider' field.
      * @param value The value of 'provider'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setProvider(java.lang.String value) {
      validate(fields()[5], value);
      this.provider = value;
      fieldSetFlags()[5] = true;
      return this;
    }

    /**
      * Checks whether the 'provider' field has been set.
      * @return True if the 'provider' field has been set, false otherwise.
      */
    public boolean hasProvider() {
      return fieldSetFlags()[5];
    }


    /**
      * Clears the value of the 'provider' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearProvider() {
      provider = null;
      fieldSetFlags()[5] = false;
      return this;
    }

    /**
      * Gets the value of the 'amount' field.
      * @return The value.
      */
    public java.lang.Double getAmount() {
      return amount;
    }

    /**
      * Sets the value of the 'amount' field.
      * @param value The value of 'amount'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setAmount(double value) {
      validate(fields()[6], value);
      this.amount = value;
      fieldSetFlags()[6] = true;
      return this;
    }

    /**
      * Checks whether the 'amount' field has been set.
      * @return True if the 'amount' field has been set, false otherwise.
      */
    public boolean hasAmount() {
      return fieldSetFlags()[6];
    }


    /**
      * Clears the value of the 'amount' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearAmount() {
      fieldSetFlags()[6] = false;
      return this;
    }

    /**
      * Gets the value of the 'tax' field.
      * @return The value.
      */
    public java.lang.Double getTax() {
      return tax;
    }

    /**
      * Sets the value of the 'tax' field.
      * @param value The value of 'tax'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setTax(double value) {
      validate(fields()[7], value);
      this.tax = value;
      fieldSetFlags()[7] = true;
      return this;
    }

    /**
      * Checks whether the 'tax' field has been set.
      * @return True if the 'tax' field has been set, false otherwise.
      */
    public boolean hasTax() {
      return fieldSetFlags()[7];
    }


    /**
      * Clears the value of the 'tax' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearTax() {
      fieldSetFlags()[7] = false;
      return this;
    }

    /**
      * Gets the value of the 'total' field.
      * @return The value.
      */
    public java.lang.Double getTotal() {
      return total;
    }

    /**
      * Sets the value of the 'total' field.
      * @param value The value of 'total'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setTotal(double value) {
      validate(fields()[8], value);
      this.total = value;
      fieldSetFlags()[8] = true;
      return this;
    }

    /**
      * Checks whether the 'total' field has been set.
      * @return True if the 'total' field has been set, false otherwise.
      */
    public boolean hasTotal() {
      return fieldSetFlags()[8];
    }


    /**
      * Clears the value of the 'total' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearTotal() {
      fieldSetFlags()[8] = false;
      return this;
    }

    /**
      * Gets the value of the 'status' field.
      * @return The value.
      */
    public java.lang.String getStatus() {
      return status;
    }

    /**
      * Sets the value of the 'status' field.
      * @param value The value of 'status'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setStatus(java.lang.String value) {
      validate(fields()[9], value);
      this.status = value;
      fieldSetFlags()[9] = true;
      return this;
    }

    /**
      * Checks whether the 'status' field has been set.
      * @return True if the 'status' field has been set, false otherwise.
      */
    public boolean hasStatus() {
      return fieldSetFlags()[9];
    }


    /**
      * Clears the value of the 'status' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearStatus() {
      status = null;
      fieldSetFlags()[9] = false;
      return this;
    }

    /**
      * Gets the value of the 'dateAndTime' field.
      * @return The value.
      */
    public java.lang.Long getDateAndTime() {
      return dateAndTime;
    }

    /**
      * Sets the value of the 'dateAndTime' field.
      * @param value The value of 'dateAndTime'.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder setDateAndTime(long value) {
      validate(fields()[10], value);
      this.dateAndTime = value;
      fieldSetFlags()[10] = true;
      return this;
    }

    /**
      * Checks whether the 'dateAndTime' field has been set.
      * @return True if the 'dateAndTime' field has been set, false otherwise.
      */
    public boolean hasDateAndTime() {
      return fieldSetFlags()[10];
    }


    /**
      * Clears the value of the 'dateAndTime' field.
      * @return This builder.
      */
    public com.diviso.graeshoppe.payment.avro.Payment.Builder clearDateAndTime() {
      fieldSetFlags()[10] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Payment build() {
      try {
        Payment record = new Payment();
        record.ref = fieldSetFlags()[0] ? this.ref : (java.lang.String) defaultValue(fields()[0]);
        record.payee = fieldSetFlags()[1] ? this.payee : (java.lang.String) defaultValue(fields()[1]);
        record.payer = fieldSetFlags()[2] ? this.payer : (java.lang.String) defaultValue(fields()[2]);
        record.targetId = fieldSetFlags()[3] ? this.targetId : (java.lang.String) defaultValue(fields()[3]);
        record.paymentType = fieldSetFlags()[4] ? this.paymentType : (java.lang.String) defaultValue(fields()[4]);
        record.provider = fieldSetFlags()[5] ? this.provider : (java.lang.String) defaultValue(fields()[5]);
        record.amount = fieldSetFlags()[6] ? this.amount : (java.lang.Double) defaultValue(fields()[6]);
        record.tax = fieldSetFlags()[7] ? this.tax : (java.lang.Double) defaultValue(fields()[7]);
        record.total = fieldSetFlags()[8] ? this.total : (java.lang.Double) defaultValue(fields()[8]);
        record.status = fieldSetFlags()[9] ? this.status : (java.lang.String) defaultValue(fields()[9]);
        record.dateAndTime = fieldSetFlags()[10] ? this.dateAndTime : (java.lang.Long) defaultValue(fields()[10]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Payment>
    WRITER$ = (org.apache.avro.io.DatumWriter<Payment>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Payment>
    READER$ = (org.apache.avro.io.DatumReader<Payment>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
