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
<div id="border_no_size" style="border-width: 10px;">
</div>

<div id="border_container_match_child" style="border-width: 10px;">
  <div style="width: 10px; height: 10px;"></div>
</div>

<div id="border_flex_child" style="width: 100px; height: 100px; border-width: 10px;">
  <div style="width: 10px; flex-grow:1"></div>
</div>

<div id="border_stretch_child" style="width: 100px; height: 100px; border-width: 10px;">
  <div style="height: 10px;"></div>
</div>

<div id="border_center_child" style="width: 100px; height: 100px; border-start-width: 10px; border-top-width: 10; border-end-width: 20px; border-bottom-width: 20px; align-items: center; justify-content: center;">
  <div style="height: 10px; width: 10px;"></div>
</div>
 *
 */

using System;
using NUnit.Framework;

namespace Facebook.CSSLayout
{
    [TestFixture]
    public class CSSLayoutBorderTest
    {
        [Test]
        public void Test_border_no_size()
        {
            CSSNode root = new CSSNode();
            root.SetBorder(CSSEdge.Left, 10);
            root.SetBorder(CSSEdge.Top, 10);
            root.SetBorder(CSSEdge.Right, 10);
            root.SetBorder(CSSEdge.Bottom, 10);
            root.StyleDirection = CSSDirection.LTR;
            root.CalculateLayout();

            Assert.AreEqual(0, root.LayoutX);
            Assert.AreEqual(0, root.LayoutY);
            Assert.AreEqual(20, root.LayoutWidth);
            Assert.AreEqual(20, root.LayoutHeight);

            root.StyleDirection = CSSDirection.RTL;
            root.CalculateLayout();

            Assert.AreEqual(0, root.LayoutX);
            Assert.AreEqual(0, root.LayoutY);
            Assert.AreEqual(20, root.LayoutWidth);
            Assert.AreEqual(20, root.LayoutHeight);
        }

        [Test]
        public void Test_border_container_match_child()
        {
            CSSNode root = new CSSNode();
            root.SetBorder(CSSEdge.Left, 10);
            root.SetBorder(CSSEdge.Top, 10);
            root.SetBorder(CSSEdge.Right, 10);
            root.SetBorder(CSSEdge.Bottom, 10);

            CSSNode root_child0 = new CSSNode();
            root_child0.StyleWidth = 10;
            root_child0.StyleHeight = 10;
            root.Insert(0, root_child0);
            root.StyleDirection = CSSDirection.LTR;
            root.CalculateLayout();

            Assert.AreEqual(0, root.LayoutX);
            Assert.AreEqual(0, root.LayoutY);
            Assert.AreEqual(30, root.LayoutWidth);
            Assert.AreEqual(30, root.LayoutHeight);

            Assert.AreEqual(10, root_child0.LayoutX);
            Assert.AreEqual(10, root_child0.LayoutY);
            Assert.AreEqual(10, root_child0.LayoutWidth);
            Assert.AreEqual(10, root_child0.LayoutHeight);

            root.StyleDirection = CSSDirection.RTL;
            root.CalculateLayout();

            Assert.AreEqual(0, root.LayoutX);
            Assert.AreEqual(0, root.LayoutY);
            Assert.AreEqual(30, root.LayoutWidth);
            Assert.AreEqual(30, root.LayoutHeight);

            Assert.AreEqual(10, root_child0.LayoutX);
            Assert.AreEqual(10, root_child0.LayoutY);
            Assert.AreEqual(10, root_child0.LayoutWidth);
            Assert.AreEqual(10, root_child0.LayoutHeight);
        }

        [Test]
        public void Test_border_flex_child()
        {
            CSSNode root = new CSSNode();
            root.SetBorder(CSSEdge.Left, 10);
            root.SetBorder(CSSEdge.Top, 10);
            root.SetBorder(CSSEdge.Right, 10);
            root.SetBorder(CSSEdge.Bottom, 10);
            root.StyleWidth = 100;
            root.StyleHeight = 100;

            CSSNode root_child0 = new CSSNode();
            root_child0.FlexGrow = 1;
            root_child0.StyleWidth = 10;
            root.Insert(0, root_child0);
            root.StyleDirection = CSSDirection.LTR;
            root.CalculateLayout();

            Assert.AreEqual(0, root.LayoutX);
            Assert.AreEqual(0, root.LayoutY);
            Assert.AreEqual(100, root.LayoutWidth);
            Assert.AreEqual(100, root.LayoutHeight);

            Assert.AreEqual(10, root_child0.LayoutX);
            Assert.AreEqual(10, root_child0.LayoutY);
            Assert.AreEqual(10, root_child0.LayoutWidth);
            Assert.AreEqual(80, root_child0.LayoutHeight);

            root.StyleDirection = CSSDirection.RTL;
            root.CalculateLayout();

            Assert.AreEqual(0, root.LayoutX);
            Assert.AreEqual(0, root.LayoutY);
            Assert.AreEqual(100, root.LayoutWidth);
            Assert.AreEqual(100, root.LayoutHeight);

            Assert.AreEqual(80, root_child0.LayoutX);
            Assert.AreEqual(10, root_child0.LayoutY);
            Assert.AreEqual(10, root_child0.LayoutWidth);
            Assert.AreEqual(80, root_child0.LayoutHeight);
        }

        [Test]
        public void Test_border_stretch_child()
        {
            CSSNode root = new CSSNode();
            root.SetBorder(CSSEdge.Left, 10);
            root.SetBorder(CSSEdge.Top, 10);
            root.SetBorder(CSSEdge.Right, 10);
            root.SetBorder(CSSEdge.Bottom, 10);
            root.StyleWidth = 100;
            root.StyleHeight = 100;

            CSSNode root_child0 = new CSSNode();
            root_child0.StyleHeight = 10;
            root.Insert(0, root_child0);
            root.StyleDirection = CSSDirection.LTR;
            root.CalculateLayout();

            Assert.AreEqual(0, root.LayoutX);
            Assert.AreEqual(0, root.LayoutY);
            Assert.AreEqual(100, root.LayoutWidth);
            Assert.AreEqual(100, root.LayoutHeight);

            Assert.AreEqual(10, root_child0.LayoutX);
            Assert.AreEqual(10, root_child0.LayoutY);
            Assert.AreEqual(80, root_child0.LayoutWidth);
            Assert.AreEqual(10, root_child0.LayoutHeight);

            root.StyleDirection = CSSDirection.RTL;
            root.CalculateLayout();

            Assert.AreEqual(0, root.LayoutX);
            Assert.AreEqual(0, root.LayoutY);
            Assert.AreEqual(100, root.LayoutWidth);
            Assert.AreEqual(100, root.LayoutHeight);

            Assert.AreEqual(10, root_child0.LayoutX);
            Assert.AreEqual(10, root_child0.LayoutY);
            Assert.AreEqual(80, root_child0.LayoutWidth);
            Assert.AreEqual(10, root_child0.LayoutHeight);
        }

        [Test]
        public void Test_border_center_child()
        {
            CSSNode root = new CSSNode();
            root.JustifyContent = CSSJustify.Center;
            root.AlignItems = CSSAlign.Center;
            root.SetBorder(CSSEdge.Start, 10);
            root.SetBorder(CSSEdge.End, 20);
            root.SetBorder(CSSEdge.Bottom, 20);
            root.StyleWidth = 100;
            root.StyleHeight = 100;

            CSSNode root_child0 = new CSSNode();
            root_child0.StyleWidth = 10;
            root_child0.StyleHeight = 10;
            root.Insert(0, root_child0);
            root.StyleDirection = CSSDirection.LTR;
            root.CalculateLayout();

            Assert.AreEqual(0, root.LayoutX);
            Assert.AreEqual(0, root.LayoutY);
            Assert.AreEqual(100, root.LayoutWidth);
            Assert.AreEqual(100, root.LayoutHeight);

            Assert.AreEqual(40, root_child0.LayoutX);
            Assert.AreEqual(35, root_child0.LayoutY);
            Assert.AreEqual(10, root_child0.LayoutWidth);
            Assert.AreEqual(10, root_child0.LayoutHeight);

            root.StyleDirection = CSSDirection.RTL;
            root.CalculateLayout();

            Assert.AreEqual(0, root.LayoutX);
            Assert.AreEqual(0, root.LayoutY);
            Assert.AreEqual(100, root.LayoutWidth);
            Assert.AreEqual(100, root.LayoutHeight);

            Assert.AreEqual(50, root_child0.LayoutX);
            Assert.AreEqual(35, root_child0.LayoutY);
            Assert.AreEqual(10, root_child0.LayoutWidth);
            Assert.AreEqual(10, root_child0.LayoutHeight);
        }

    }
}
