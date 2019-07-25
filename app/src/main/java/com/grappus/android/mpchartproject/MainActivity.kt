package com.grappus.android.mpchartproject

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.View
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.DefaultValueFormatter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View?) {
        when (view) {
            refreshButton -> prepareChart()
        }
    }

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponents()
    }

    private fun initComponents() {
        pieChart = findViewById(R.id.piechart)
        refreshButton.setOnClickListener(this)
        prepareChart()
    }

    private fun prepareChart() {

        val yvalues = ArrayList<PieEntry>()
        yvalues.add(PieEntry(25f, 0))
        yvalues.add(PieEntry(40f, 0))
        yvalues.add(PieEntry(35f, 0))


        val dataSet = PieDataSet(yvalues, "")
        dataSet.sliceSpace = 3f
        dataSet.setShaders(getGradientShadersList())


        val data = PieData(dataSet)
        data.setDrawValues(false)
        data.setValueFormatter(DefaultValueFormatter(0))
        data.setValueTextColor(Color.DKGRAY)

        pieChart.data = data
        pieChart.isDrawHoleEnabled = false
        pieChart.setUsePercentValues(true)
        pieChart.description.isEnabled = false
        pieChart.isRotationEnabled = false
        pieChart.setDrawEntryLabels(false)
        pieChart.highlightValues(null)
        pieChart.legend.isEnabled = false
        pieChart.transparentCircleRadius = 100f
        pieChart.animateXY(1400, 1400)
    }

    private fun getGradientShadersList(): List<Shader> {

        val startColor = arrayOf("#ff6936", "#73c0ff", "#c5e91a")
        val endColor = arrayOf("#ff2bf1", "#8554ff", "#1ccfb9")

        val list = ArrayList<Shader>()
        for (i in 0..2) {
            list.add(LinearGradient(dpToPxFloat(50f), dpToPxFloat(50f), dpToPxFloat(100f), dpToPxFloat(100f),
                    Color.parseColor(startColor[i]), Color.parseColor(endColor[i]), Shader.TileMode.CLAMP))
        }
        return list
    }

    private fun dpToPxFloat(dp: Float): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, this.resources.displayMetrics)
    }
}
