/**
 * Copyright (c) 2014-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

/**
 * @Generated by gentest/gentest.sh with the following input
 *
<div id="max_width" style="width: 100px; height: 100px;">
  <div style="height: 10px; max-width: 50px;"></div>
</div>

<div id="max_height" style="width: 100px; height: 100px; flex-direction: row;">
  <div style="width: 10px; max-height: 50px;"></div>
</div>

<div id="min_height" style="width: 100px; height: 100px;">
  <div style="flex-grow: 1; min-height: 60px;"></div>
  <div style="flex-grow: 1;"></div>
</div>

<div id="min_width" style="width: 100px; height: 100px; flex-direction: row">
  <div style="flex-grow: 1; min-width: 60px;"></div>
  <div style="flex-grow: 1;"></div>
</div>

<div id="justify_content_min_max" style="max-height: 200px; min-height: 100px; width: 100px; justify-content: center;">
  <div style="width: 60px; height: 60px;"></div>
</div>

<div id="align_items_min_max" style="max-width: 200px; min-width: 100px; height: 100px; align-items: center;">
  <div style="width: 60px; height: 60px;"></div>
</div>

<div id="justify_content_overflow_min_max" style="min-height: 100px; max-height: 110px; justify-content: center;">
  <div style="width: 50px; height: 50px;"></div>
  <div style="width: 50px; height: 50px;"></div>
  <div style="width: 50px; height: 50px;"></div>
</div>

<div id="flex_grow_within_max_width" style="width: 200px; height: 100px;">
  <div style="flex-direction: row; max-width: 100px;">
    <div style="height: 20px; flex-grow: 1;"></div>
  </div>
</div>

<div id="flex_grow_within_constrained_max_width" style="width: 200px; height: 100px;">
  <div style="flex-direction: row; max-width: 300px;">
    <div style="height: 20px; flex-grow: 1;"></div>
  </div>
</div>
 *
 */

package com.facebook.csslayout;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CSSLayoutMinMaxDimensionTest {
  @Test
  public void test_max_width() {
    final CSSNode root = new CSSNode();
    root.setStyleWidth(100);
    root.setStyleHeight(100);

    final CSSNode root_child0 = new CSSNode();
    root_child0.setStyleMaxWidth(50);
    root_child0.setStyleHeight(10);
    root.addChildAt(root_child0, 0);
    root.setDirection(CSSDirection.LTR);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(50, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(10, root_child0.getLayoutHeight(), 0.0f);

    root.setDirection(CSSDirection.RTL);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(50, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(50, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(10, root_child0.getLayoutHeight(), 0.0f);
  }

  @Test
  public void test_max_height() {
    final CSSNode root = new CSSNode();
    root.setFlexDirection(CSSFlexDirection.ROW);
    root.setStyleWidth(100);
    root.setStyleHeight(100);

    final CSSNode root_child0 = new CSSNode();
    root_child0.setStyleWidth(10);
    root_child0.setStyleMaxHeight(50);
    root.addChildAt(root_child0, 0);
    root.setDirection(CSSDirection.LTR);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(10, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(50, root_child0.getLayoutHeight(), 0.0f);

    root.setDirection(CSSDirection.RTL);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(90, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(10, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(50, root_child0.getLayoutHeight(), 0.0f);
  }

  @Test
  public void test_min_height() {
    final CSSNode root = new CSSNode();
    root.setStyleWidth(100);
    root.setStyleHeight(100);

    final CSSNode root_child0 = new CSSNode();
    root_child0.setFlexGrow(1);
    root_child0.setStyleMinHeight(60);
    root.addChildAt(root_child0, 0);

    final CSSNode root_child1 = new CSSNode();
    root_child1.setFlexGrow(1);
    root.addChildAt(root_child1, 1);
    root.setDirection(CSSDirection.LTR);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(100, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(80, root_child0.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child1.getLayoutX(), 0.0f);
    assertEquals(80, root_child1.getLayoutY(), 0.0f);
    assertEquals(100, root_child1.getLayoutWidth(), 0.0f);
    assertEquals(20, root_child1.getLayoutHeight(), 0.0f);

    root.setDirection(CSSDirection.RTL);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(100, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(80, root_child0.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child1.getLayoutX(), 0.0f);
    assertEquals(80, root_child1.getLayoutY(), 0.0f);
    assertEquals(100, root_child1.getLayoutWidth(), 0.0f);
    assertEquals(20, root_child1.getLayoutHeight(), 0.0f);
  }

  @Test
  public void test_min_width() {
    final CSSNode root = new CSSNode();
    root.setFlexDirection(CSSFlexDirection.ROW);
    root.setStyleWidth(100);
    root.setStyleHeight(100);

    final CSSNode root_child0 = new CSSNode();
    root_child0.setFlexGrow(1);
    root_child0.setStyleMinWidth(60);
    root.addChildAt(root_child0, 0);

    final CSSNode root_child1 = new CSSNode();
    root_child1.setFlexGrow(1);
    root.addChildAt(root_child1, 1);
    root.setDirection(CSSDirection.LTR);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(80, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(100, root_child0.getLayoutHeight(), 0.0f);

    assertEquals(80, root_child1.getLayoutX(), 0.0f);
    assertEquals(0, root_child1.getLayoutY(), 0.0f);
    assertEquals(20, root_child1.getLayoutWidth(), 0.0f);
    assertEquals(100, root_child1.getLayoutHeight(), 0.0f);

    root.setDirection(CSSDirection.RTL);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(20, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(80, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(100, root_child0.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child1.getLayoutX(), 0.0f);
    assertEquals(0, root_child1.getLayoutY(), 0.0f);
    assertEquals(20, root_child1.getLayoutWidth(), 0.0f);
    assertEquals(100, root_child1.getLayoutHeight(), 0.0f);
  }

  @Test
  public void test_justify_content_min_max() {
    final CSSNode root = new CSSNode();
    root.setJustifyContent(CSSJustify.CENTER);
    root.setStyleWidth(100);
    root.setStyleMinHeight(100);
    root.setStyleMaxHeight(200);

    final CSSNode root_child0 = new CSSNode();
    root_child0.setStyleWidth(60);
    root_child0.setStyleHeight(60);
    root.addChildAt(root_child0, 0);
    root.setDirection(CSSDirection.LTR);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(20, root_child0.getLayoutY(), 0.0f);
    assertEquals(60, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(60, root_child0.getLayoutHeight(), 0.0f);

    root.setDirection(CSSDirection.RTL);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(40, root_child0.getLayoutX(), 0.0f);
    assertEquals(20, root_child0.getLayoutY(), 0.0f);
    assertEquals(60, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(60, root_child0.getLayoutHeight(), 0.0f);
  }

  @Test
  public void test_align_items_min_max() {
    final CSSNode root = new CSSNode();
    root.setAlignItems(CSSAlign.CENTER);
    root.setStyleMinWidth(100);
    root.setStyleMaxWidth(200);
    root.setStyleHeight(100);

    final CSSNode root_child0 = new CSSNode();
    root_child0.setStyleWidth(60);
    root_child0.setStyleHeight(60);
    root.addChildAt(root_child0, 0);
    root.setDirection(CSSDirection.LTR);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(20, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(60, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(60, root_child0.getLayoutHeight(), 0.0f);

    root.setDirection(CSSDirection.RTL);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(100, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(20, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(60, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(60, root_child0.getLayoutHeight(), 0.0f);
  }

  @Test
  public void test_justify_content_overflow_min_max() {
    final CSSNode root = new CSSNode();
    root.setJustifyContent(CSSJustify.CENTER);
    root.setStyleMinHeight(100);
    root.setStyleMaxHeight(110);

    final CSSNode root_child0 = new CSSNode();
    root_child0.setStyleWidth(50);
    root_child0.setStyleHeight(50);
    root.addChildAt(root_child0, 0);

    final CSSNode root_child1 = new CSSNode();
    root_child1.setStyleWidth(50);
    root_child1.setStyleHeight(50);
    root.addChildAt(root_child1, 1);

    final CSSNode root_child2 = new CSSNode();
    root_child2.setStyleWidth(50);
    root_child2.setStyleHeight(50);
    root.addChildAt(root_child2, 2);
    root.setDirection(CSSDirection.LTR);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(50, root.getLayoutWidth(), 0.0f);
    assertEquals(110, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(-20, root_child0.getLayoutY(), 0.0f);
    assertEquals(50, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(50, root_child0.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child1.getLayoutX(), 0.0f);
    assertEquals(30, root_child1.getLayoutY(), 0.0f);
    assertEquals(50, root_child1.getLayoutWidth(), 0.0f);
    assertEquals(50, root_child1.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child2.getLayoutX(), 0.0f);
    assertEquals(80, root_child2.getLayoutY(), 0.0f);
    assertEquals(50, root_child2.getLayoutWidth(), 0.0f);
    assertEquals(50, root_child2.getLayoutHeight(), 0.0f);

    root.setDirection(CSSDirection.RTL);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(50, root.getLayoutWidth(), 0.0f);
    assertEquals(110, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(-20, root_child0.getLayoutY(), 0.0f);
    assertEquals(50, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(50, root_child0.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child1.getLayoutX(), 0.0f);
    assertEquals(30, root_child1.getLayoutY(), 0.0f);
    assertEquals(50, root_child1.getLayoutWidth(), 0.0f);
    assertEquals(50, root_child1.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child2.getLayoutX(), 0.0f);
    assertEquals(80, root_child2.getLayoutY(), 0.0f);
    assertEquals(50, root_child2.getLayoutWidth(), 0.0f);
    assertEquals(50, root_child2.getLayoutHeight(), 0.0f);
  }

  @Test
  public void test_flex_grow_within_max_width() {
    final CSSNode root = new CSSNode();
    root.setStyleWidth(200);
    root.setStyleHeight(100);

    final CSSNode root_child0 = new CSSNode();
    root_child0.setFlexDirection(CSSFlexDirection.ROW);
    root_child0.setStyleMaxWidth(100);
    root.addChildAt(root_child0, 0);

    final CSSNode root_child0_child0 = new CSSNode();
    root_child0_child0.setFlexGrow(1);
    root_child0_child0.setStyleHeight(20);
    root_child0.addChildAt(root_child0_child0, 0);
    root.setDirection(CSSDirection.LTR);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(200, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(100, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(20, root_child0.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0_child0.getLayoutY(), 0.0f);
    assertEquals(100, root_child0_child0.getLayoutWidth(), 0.0f);
    assertEquals(20, root_child0_child0.getLayoutHeight(), 0.0f);

    root.setDirection(CSSDirection.RTL);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(200, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(100, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(100, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(20, root_child0.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0_child0.getLayoutY(), 0.0f);
    assertEquals(100, root_child0_child0.getLayoutWidth(), 0.0f);
    assertEquals(20, root_child0_child0.getLayoutHeight(), 0.0f);
  }

  @Test
  public void test_flex_grow_within_constrained_max_width() {
    final CSSNode root = new CSSNode();
    root.setStyleWidth(200);
    root.setStyleHeight(100);

    final CSSNode root_child0 = new CSSNode();
    root_child0.setFlexDirection(CSSFlexDirection.ROW);
    root_child0.setStyleMaxWidth(300);
    root.addChildAt(root_child0, 0);

    final CSSNode root_child0_child0 = new CSSNode();
    root_child0_child0.setFlexGrow(1);
    root_child0_child0.setStyleHeight(20);
    root_child0.addChildAt(root_child0_child0, 0);
    root.setDirection(CSSDirection.LTR);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(200, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(200, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(20, root_child0.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0_child0.getLayoutY(), 0.0f);
    assertEquals(200, root_child0_child0.getLayoutWidth(), 0.0f);
    assertEquals(20, root_child0_child0.getLayoutHeight(), 0.0f);

    root.setDirection(CSSDirection.RTL);
    root.calculateLayout(null);

    assertEquals(0, root.getLayoutX(), 0.0f);
    assertEquals(0, root.getLayoutY(), 0.0f);
    assertEquals(200, root.getLayoutWidth(), 0.0f);
    assertEquals(100, root.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0.getLayoutY(), 0.0f);
    assertEquals(200, root_child0.getLayoutWidth(), 0.0f);
    assertEquals(20, root_child0.getLayoutHeight(), 0.0f);

    assertEquals(0, root_child0_child0.getLayoutX(), 0.0f);
    assertEquals(0, root_child0_child0.getLayoutY(), 0.0f);
    assertEquals(200, root_child0_child0.getLayoutWidth(), 0.0f);
    assertEquals(20, root_child0_child0.getLayoutHeight(), 0.0f);
  }

}
