package com.coneyang.blockchains;

import java.util.concurrent.ConcurrentMap;

/**
 * @author YangLei
 * @version 1.0.0.1
 * @since 2020/7/15 17:03
 */
public class TestResizer {
    private int unitWidth;
    private int unitHeight;
    private int matrixRow;
    private int matrixColumn;
    private int canvasWidth;
    private int canvasHeight;
    private int offsetX;
    private int offsetY;
    private int offsetWidth;
    private int offsetHeight;

    public TestResizer(int unitWidth, int unitHeight, int matrixRow, int matrixColumn, int canvasWidth, int canvasHeight) {
        this.unitWidth = unitWidth;
        this.unitHeight = unitHeight;
        this.matrixRow = matrixRow;
        this.matrixColumn = matrixColumn;
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
        doCompute();
    }

    public static void main(String[] args) {
        TestResizer resizer = new TestResizer(1920,1080,1,1,1000,600);
        System.out.println(resizer.offsetX);
        System.out.println(resizer.offsetY);
        System.out.println(resizer.offsetWidth);
        System.out.println(resizer.offsetHeight);
    }

    private void doCompute() {
        int computWidth = this.canvasWidth;
       while (computWidth%this.matrixColumn != 0){
           computWidth--;
       }
        this.offsetWidth = computWidth / this.matrixColumn;
        this.offsetHeight = this.offsetWidth * this.unitHeight / this.unitWidth;
        if(this.offsetHeight*this.matrixRow > this.canvasHeight){
            int computHeight = this.canvasHeight;
            while (computHeight%this.matrixRow != 0){
                computHeight--;
            }
            this.offsetHeight = computHeight / this.matrixRow;
            this.offsetWidth = this.offsetHeight * this.unitWidth / this.unitHeight;
        }
        this.offsetX = (this.canvasWidth - this.offsetWidth * this.matrixColumn) / 2;
        this.offsetY = (this.canvasHeight - this.offsetHeight * this.matrixRow) / 2;
    }

    public int getOffsetX() {
        return this.offsetX;
    }

    public int getOffsetY() {
        return this.offsetY;
    }

    public int getOffsetWidth() {
        return this.offsetWidth;
    }

    public int getOffsetHeight() {
        return this.offsetHeight;
    }

}
