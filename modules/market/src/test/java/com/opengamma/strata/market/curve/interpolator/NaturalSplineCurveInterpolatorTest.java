/*
 * Copyright (C) 2016 - present by OpenGamma Inc. and the OpenGamma group of companies
 *
 * Please see distribution for license.
 */
package com.opengamma.strata.market.curve.interpolator;

import static com.opengamma.strata.collect.TestHelper.assertSerialization;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.opengamma.strata.collect.array.DoubleArray;

/**
 * Test {@link NaturalSplineCurveInterpolator}.
 */
@Test
public class NaturalSplineCurveInterpolatorTest {

  private static final CurveInterpolator NATURAL_SPLINE_INTERPOLATOR = NaturalSplineCurveInterpolator.INSTANCE;
  private static final CurveExtrapolator FLAT_EXTRAPOLATOR = CurveExtrapolators.FLAT;

  private static final DoubleArray X_DATA = DoubleArray.of(0.0, 0.4, 1.0, 1.8, 2.8, 5.0);
  private static final DoubleArray Y_DATA = DoubleArray.of(3.0, 4.0, 3.1, 2.0, 7.0, 2.0);
  private static final DoubleArray X_TEST = DoubleArray.of(0.2, 1.1, 2.3);
  private static final DoubleArray Y_TEST = DoubleArray.of(3.616894743727217, 2.8102203061222415, 4.223324003010826);
  private static final double TOL = 1.e-12;

  public void test_basics() {
    assertEquals(NATURAL_SPLINE_INTERPOLATOR.getName(), NaturalSplineCurveInterpolator.NAME);
    assertEquals(NATURAL_SPLINE_INTERPOLATOR.toString(), NaturalSplineCurveInterpolator.NAME);
  }

  //-------------------------------------------------------------------------
  public void test_interpolation() {
    BoundCurveInterpolator bci = NATURAL_SPLINE_INTERPOLATOR.bind(X_DATA, Y_DATA, FLAT_EXTRAPOLATOR, FLAT_EXTRAPOLATOR);
    for (int i = 0; i < X_DATA.size(); i++) {
      assertEquals(bci.interpolate(X_DATA.get(i)), Y_DATA.get(i), TOL);
    }
    for (int i = 0; i < X_TEST.size(); i++) {
      assertEquals(bci.interpolate(X_TEST.get(i)), Y_TEST.get(i), TOL);
    }
  }

  public void test_firstDerivative() {
    BoundCurveInterpolator bci = NATURAL_SPLINE_INTERPOLATOR.bind(X_DATA, Y_DATA, FLAT_EXTRAPOLATOR, FLAT_EXTRAPOLATOR);
    double eps = 1e-8;
    double lo = bci.interpolate(0.2);
    double hi = bci.interpolate(0.2 + eps);
    double deriv = (hi - lo) / eps;
    assertEquals(bci.firstDerivative(0.2), deriv, 1e-6);
  }

  //-------------------------------------------------------------------------
  public void test_firstNode() {
    BoundCurveInterpolator bci = NATURAL_SPLINE_INTERPOLATOR.bind(X_DATA, Y_DATA, FLAT_EXTRAPOLATOR, FLAT_EXTRAPOLATOR);
    assertEquals(bci.interpolate(0.0), 3.0, TOL);
    assertEquals(bci.parameterSensitivity(0.0).get(0), 1d, TOL);
    assertEquals(bci.parameterSensitivity(0.0).get(1), 0d, TOL);
  }

  public void test_allNodes() {
    BoundCurveInterpolator bci = NATURAL_SPLINE_INTERPOLATOR.bind(X_DATA, Y_DATA, FLAT_EXTRAPOLATOR, FLAT_EXTRAPOLATOR);
    for (int i = 0; i < X_DATA.size(); i++) {
      assertEquals(bci.interpolate(X_DATA.get(i)), Y_DATA.get(i), TOL);
    }
  }

  public void test_lastNode() {
    BoundCurveInterpolator bci = NATURAL_SPLINE_INTERPOLATOR.bind(X_DATA, Y_DATA, FLAT_EXTRAPOLATOR, FLAT_EXTRAPOLATOR);
    assertEquals(bci.interpolate(5.0), 2.0, TOL);
    assertEquals(bci.parameterSensitivity(5.0).get(X_DATA.size() - 2), 0d, TOL);
    assertEquals(bci.parameterSensitivity(5.0).get(X_DATA.size() - 1), 1d, TOL);
  }

  //-------------------------------------------------------------------------
  public void test_serialization() {
    assertSerialization(NATURAL_SPLINE_INTERPOLATOR);
  }

}
