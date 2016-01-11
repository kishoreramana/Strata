/**
 * Copyright (C) 2015 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.function.marketdata.mapping;

import java.io.Serializable;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.joda.beans.BeanBuilder;
import org.joda.beans.BeanDefinition;
import org.joda.beans.ImmutableBean;
import org.joda.beans.JodaBeanUtils;
import org.joda.beans.MetaProperty;
import org.joda.beans.Property;
import org.joda.beans.impl.direct.DirectFieldsBeanBuilder;
import org.joda.beans.impl.direct.DirectMetaBean;
import org.joda.beans.impl.direct.DirectMetaPropertyMap;

import com.opengamma.strata.calc.marketdata.mapping.MarketDataMapping;
import com.opengamma.strata.market.id.SwaptionVolatilitiesId;
import com.opengamma.strata.market.key.SwaptionVolatilitiesKey;
import com.opengamma.strata.market.view.SwaptionVolatilities;

/**
 * Market data mapping for swaption volatilities.
 * <p>
 * It accepts a {@link SwaptionVolatilitiesKey} and returns a {@link SwaptionVolatilitiesId}.
 * No additional information is required.
 */
@BeanDefinition(builderScope = "private")
public final class SwaptionVolatilitiesMapping
    implements MarketDataMapping<SwaptionVolatilities, SwaptionVolatilitiesKey>, ImmutableBean, Serializable {

  /**
   * Obtains a {@code SwaptionVolatilitiesMapping}.
   * <p>
   * The result will map a {@link SwaptionVolatilitiesKey} to a {@link SwaptionVolatilitiesId}.
   *
   * @return a mapping
   */
  public static SwaptionVolatilitiesMapping of() {
    return new SwaptionVolatilitiesMapping();
  }

  //-------------------------------------------------------------------------
  @Override
  public Class<SwaptionVolatilitiesKey> getMarketDataKeyType() {
    return SwaptionVolatilitiesKey.class;
  }

  @Override
  public SwaptionVolatilitiesId getIdForKey(SwaptionVolatilitiesKey key) {
    return SwaptionVolatilitiesId.of(key.getIndex());
  }

  //------------------------- AUTOGENERATED START -------------------------
  ///CLOVER:OFF
  /**
   * The meta-bean for {@code SwaptionVolatilitiesMapping}.
   * @return the meta-bean, not null
   */
  public static SwaptionVolatilitiesMapping.Meta meta() {
    return SwaptionVolatilitiesMapping.Meta.INSTANCE;
  }

  static {
    JodaBeanUtils.registerMetaBean(SwaptionVolatilitiesMapping.Meta.INSTANCE);
  }

  /**
   * The serialization version id.
   */
  private static final long serialVersionUID = 1L;

  private SwaptionVolatilitiesMapping() {
  }

  @Override
  public SwaptionVolatilitiesMapping.Meta metaBean() {
    return SwaptionVolatilitiesMapping.Meta.INSTANCE;
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
  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj != null && obj.getClass() == this.getClass()) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int hash = getClass().hashCode();
    return hash;
  }

  @Override
  public String toString() {
    StringBuilder buf = new StringBuilder(32);
    buf.append("SwaptionVolatilitiesMapping{");
    buf.append('}');
    return buf.toString();
  }

  //-----------------------------------------------------------------------
  /**
   * The meta-bean for {@code SwaptionVolatilitiesMapping}.
   */
  public static final class Meta extends DirectMetaBean {
    /**
     * The singleton instance of the meta-bean.
     */
    static final Meta INSTANCE = new Meta();

    /**
     * The meta-properties.
     */
    private final Map<String, MetaProperty<?>> metaPropertyMap$ = new DirectMetaPropertyMap(
        this, null);

    /**
     * Restricted constructor.
     */
    private Meta() {
    }

    @Override
    public BeanBuilder<? extends SwaptionVolatilitiesMapping> builder() {
      return new SwaptionVolatilitiesMapping.Builder();
    }

    @Override
    public Class<? extends SwaptionVolatilitiesMapping> beanType() {
      return SwaptionVolatilitiesMapping.class;
    }

    @Override
    public Map<String, MetaProperty<?>> metaPropertyMap() {
      return metaPropertyMap$;
    }

    //-----------------------------------------------------------------------
  }

  //-----------------------------------------------------------------------
  /**
   * The bean-builder for {@code SwaptionVolatilitiesMapping}.
   */
  private static final class Builder extends DirectFieldsBeanBuilder<SwaptionVolatilitiesMapping> {

    /**
     * Restricted constructor.
     */
    private Builder() {
    }

    //-----------------------------------------------------------------------
    @Override
    public Object get(String propertyName) {
      throw new NoSuchElementException("Unknown property: " + propertyName);
    }

    @Override
    public Builder set(String propertyName, Object newValue) {
      throw new NoSuchElementException("Unknown property: " + propertyName);
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
    public SwaptionVolatilitiesMapping build() {
      return new SwaptionVolatilitiesMapping();
    }

    //-----------------------------------------------------------------------
    @Override
    public String toString() {
      return "SwaptionVolatilitiesMapping.Builder{}";
    }

  }

  ///CLOVER:ON
  //-------------------------- AUTOGENERATED END --------------------------
}
