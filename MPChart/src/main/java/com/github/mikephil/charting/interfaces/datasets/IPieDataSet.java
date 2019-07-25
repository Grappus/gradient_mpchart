package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.Shader;

import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.List;

/**
 * Created by Philipp Jahoda on 03/11/15.
 */
public interface IPieDataSet extends IDataSet<PieEntry> {

    /**
     * Returns the space that is set to be between the piechart-slices of this
     * DataSet, in pixels.
     *
     * @return
     */
    float getSliceSpace();

    /**
     * When enabled, slice spacing will be 0.0 when the smallest value is going to be
     *   smaller than the slice spacing itself.
     *
     * @return
     */
    boolean isAutomaticallyDisableSliceSpacingEnabled();

    /**
     * Returns the distance a highlighted piechart slice is "shifted" away from
     * the chart-center in dp.
     *
     * @return
     */
    float getSelectionShift();

    PieDataSet.ValuePosition getXValuePosition();
    PieDataSet.ValuePosition getYValuePosition();

    /**
     * When valuePosition is OutsideSlice, use slice colors as line color if true
     * */
    boolean isUsingSliceColorAsValueLineColor();

    /**
     * Returns the gradient shader at the given index of the DataSet's gradient shader array.
     * Performs a IndexOutOfBounds check by modulus.
     *
     * @return
     */
    List<Shader> getGradientShaders();

    /**
     * Returns the gradient shader at the given index of the DataSet's gradient shader array.
     * Performs a IndexOutOfBounds check by modulus.
     *
     * @param index
     * @return
     */
    Shader getGradientShader(int index);

    /**
     * When valuePosition is OutsideSlice, indicates line color
     * */
    int getValueLineColor();

    /**
     *  When valuePosition is OutsideSlice, indicates line width
     *  */
    float getValueLineWidth();

    /**
     * When valuePosition is OutsideSlice, indicates offset as percentage out of the slice size
     * */
    float getValueLinePart1OffsetPercentage();

    /**
     * When valuePosition is OutsideSlice, indicates length of first half of the line
     * */
    float getValueLinePart1Length();

    /**
     * When valuePosition is OutsideSlice, indicates length of second half of the line
     * */
    float getValueLinePart2Length();

    /**
     * When valuePosition is OutsideSlice, this allows variable line length
     * */
    boolean isValueLineVariableLength();

}

