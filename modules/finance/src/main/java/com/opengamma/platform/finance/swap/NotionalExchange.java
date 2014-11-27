/**
 * Copyright (C) 2014 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.platform.finance.swap;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.Bean;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.PropertyDefinition;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaProperty;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.basics.currency.Currency;
import com.opengamma.basics.currency.CurrencyAmount;

/**
 * An exchange of notionals between two counterparties.
 * <p>
 * In most swaps, the notional amount is not exchanged, with only the net difference being exchanged.
 * However, in certain cases, initial, final or intermediate amounts are exchanged.
 * In this case, the notional can be referred to as the principal.
 */
@BeanDefinition
public final class NotionalExchange
    implements PaymentEvent, ImmutableBean, Serializable {

  /** Serialization version. */
  private static final long serialVersionUID = 1L;

  /**
   * The date that payment occurs.
   * <p>
   * The date that payment is made for the event.
   * This date has been adjusted to be a valid business day.
   */
  @PropertyDefinition(validate = "notNull", overrideGet = true)
  private final LocalDate paymentDate;
  /**
   * The flag indicating whether to exchange the final notional.
   */
  @PropertyDefinition(validate = "notNull")
  private final CurrencyAmount paymentAmount;

  //-------------------------------------------------------------------------
  /**
   * Gets the currency of the event.
   * <p>
   * An event has a single currency.
   * 
   * @return the currency of the event
   */
  @Override
  public Currency getCurrency() {
    return paymentAmount.getCurrency();
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code NotionalExchange}.
   * @return the meta-bean, not null
   */
  public static NotionalExchange.Meta meta() {
    return NotionalExchange.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(NotionalExchange.Meta.INSTANCE);
  }

  /**
   * Returns a builder used to create an instance of the bean.
   * @return the builder, not null
   */
  public static NotionalExchange.Builder builder() {
    return new NotionalExchange.Builder();
  }

  private NotionalExchange(
      LocalDate paymentDate,
      CurrencyAmount paymentAmount) {
    JodaBeanUtils.notNull(paymentDate, "paymentDate");
    JodaBeanUtils.notNull(paymentAmount, "paymentAmount");
    this.paymentDate = paymentDate;
    this.paymentAmount = paymentAmount;
  }

  @Override
  public NotionalExchange.Meta metaBean() {
    return NotionalExchange.Meta.INSTANCE;
  }

  @Override
  public <R> Property<R> property(String propertyName) {
    return metaBean().<R>metaProperty(propertyName).createProperty(this);
  }

  @Override
  public Set<String> propertyNames() {
    return metaBean().metaPropertyMap().keySet();
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the date that payment occurs.
   * <p>
   * The date that payment is made for the event.
   * This date has been adjusted to be a valid business day.
   * @return the value of the property, not null
   */
  @Override
  public LocalDate getPaymentDate() {
    return paymentDate;
  }

  //-----------------------------------------------------------------------
  /**
   * Gets the flag indicating whether to exchange the final notional.
   * @return the value of the property, not null
   */
  public CurrencyAmount getPaymentAmount() {
    return paymentAmount;
  }

  //-----------------------------------------------------------------------
  /**
   * Returns a builder that allows this bean to be mutated.
   * @return the mutable builder, not null
   */
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      NotionalExchange other = (NotionalExchange) obj;
      return JodaBeanUtils.equal(getPaymentDate(), other.getPaymentDate()) &&
          JodaBeanUtils.equal(getPaymentAmount(), other.getPaymentAmount());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    hash += hash * 31 + JodaBeanUtils.hashCode(getPaymentDate());
    hash += hash * 31 + JodaBeanUtils.hashCode(getPaymentAmount());
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(96);
    buf.append("NotionalExchange{");
    buf.append("paymentDate").append('=').append(getPaymentDate()).append(',').append(' ');
    buf.append("paymentAmount").append('=').append(JodaBeanUtils.toString(getPaymentAmount()));
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code NotionalExchange}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-property for the {@code paymentDate} property.
     */
    private final MetaProperty<LocalDate> paymentDate = DirectMetaProperty.ofImmutable(
        this, "paymentDate", NotionalExchange.class, LocalDate.class);
    /**
     * The meta-property for the {@code paymentAmount} property.
     */
    private final MetaProperty<CurrencyAmount> paymentAmount = DirectMetaProperty.ofImmutable(
        this, "paymentAmount", NotionalExchange.class, CurrencyAmount.class);
    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null,
        "paymentDate",
        "paymentAmount");

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    protected MetaProperty<?> metaPropertyGet(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1540873516:  // paymentDate
          return paymentDate;
        case 909332990:  // paymentAmount
          return paymentAmount;
      }
      return super.metaPropertyGet(propertyName);
    }

    @Override
    public NotionalExchange.Builder builder() {
      return new NotionalExchange.Builder();
    }

    @Override
    public Class<? extends NotionalExchange> beanType() {
      return NotionalExchange.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
    /**
     * The meta-property for the {@code paymentDate} property.
     * @return the meta-property, not null
     */
    public MetaProperty<LocalDate> paymentDate() {
      return paymentDate;
    }

    /**
     * The meta-property for the {@code paymentAmount} property.
     * @return the meta-property, not null
     */
    public MetaProperty<CurrencyAmount> paymentAmount() {
      return paymentAmount;
    }

    //-----------------------------------------------------------------------
    @Override
    protected Object propertyGet(Bean bean, String propertyName, boolean quiet) {
      switch (propertyName.hashCode()) {
        case -1540873516:  // paymentDate
          return ((NotionalExchange) bean).getPaymentDate();
        case 909332990:  // paymentAmount
          return ((NotionalExchange) bean).getPaymentAmount();
      }
      return super.propertyGet(bean, propertyName, quiet);
    }

    @Override
    protected void propertySet(Bean bean, String propertyName, Object newValue, boolean quiet) {
      metaProperty(propertyName);
      if (quiet) {
        return;
      }
      throw new UnsupportedOperationException("Property cannot be written: " + propertyName);
    }

  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code NotionalExchange}.
   */
  public static final class Builder extends DirectFieldsBeanBuilder<NotionalExchange> {

    private LocalDate paymentDate;
    private CurrencyAmount paymentAmount;

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    /**
     * Restricted copy constructor.
     * @param beanToCopy  the bean to copy from, not null
     */
    private Builder(NotionalExchange beanToCopy) {
      this.paymentDate = beanToCopy.getPaymentDate();
      this.paymentAmount = beanToCopy.getPaymentAmount();
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      switch (propertyName.hashCode()) {
        case -1540873516:  // paymentDate
          return paymentDate;
        case 909332990:  // paymentAmount
          return paymentAmount;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      switch (propertyName.hashCode()) {
        case -1540873516:  // paymentDate
          this.paymentDate = (LocalDate) newValue;
          break;
        case 909332990:  // paymentAmount
          this.paymentAmount = (CurrencyAmount) newValue;
          break;
        default:
          throw new NoSuchElementException("Unknown property: " + propertyName);
      }
      return this;
    }

    @Override
    public Builder set(MetaProperty<?> property, Object value) {
      super.set(property, value);
      return this;
    }

    @Override
    public Builder setString(String propertyName, String value) {
      setString(meta().metaProperty(propertyName), value);
      return this;
    }

    @Override
    public Builder setString(MetaProperty<?> property, String value) {
      super.setString(property, value);
      return this;
    }

    @Override
    public Builder setAll(Map<String, ? extends Object> propertyValueMap) {
      super.setAll(propertyValueMap);
      return this;
    }

    @Override
    public NotionalExchange build() {
      return new NotionalExchange(
          paymentDate,
          paymentAmount);
    }

    //-----------------------------------------------------------------------
    /**
     * Sets the {@code paymentDate} property in the builder.
     * @param paymentDate  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder paymentDate(LocalDate paymentDate) {
      JodaBeanUtils.notNull(paymentDate, "paymentDate");
      this.paymentDate = paymentDate;
      return this;
    }

    /**
     * Sets the {@code paymentAmount} property in the builder.
     * @param paymentAmount  the new value, not null
     * @return this, for chaining, not null
     */
    public Builder paymentAmount(CurrencyAmount paymentAmount) {
      JodaBeanUtils.notNull(paymentAmount, "paymentAmount");
      this.paymentAmount = paymentAmount;
      return this;
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      StringBuilder buf = new StringBuilder(96);
      buf.append("NotionalExchange.Builder{");
      buf.append("paymentDate").append('=').append(JodaBeanUtils.toString(paymentDate)).append(',').append(' ');
      buf.append("paymentAmount").append('=').append(JodaBeanUtils.toString(paymentAmount));
      buf.append('}');
      return buf.toString();
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
