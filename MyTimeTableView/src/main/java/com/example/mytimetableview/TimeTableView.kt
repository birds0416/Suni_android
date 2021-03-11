package com.example.mytimetableview

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout

open class TimeTableView: LinearLayout {

    protected var topMenuHeight: Int = 20
    protected var leftMenuWidth: Int = 30
    protected var cellHeight: Int = 50

    protected var isRatio: Boolean = false
    protected var cellRatio: Float = 0f

    protected var tableContext: Context = context

    protected var topMenuHeightPx: Float = 0.0f
    protected var leftMenuWidthPx: Float = 0.0f
    protected var cellHeightPx: Float = 0.0f
    protected var averageWidth: Int = 0
    protected var widthPaddingPx: Float = 0.0f

    protected var tableStartTime: Int = 9
    protected var tableEndTime: Int = 16

    protected var dayList: Array<String> = arrayOf()

    protected var radiusStyle: Int = 0
    protected var isTwentyFourHourClock = true
    protected var cellColor = 0
    protected var menuColor = 0
    protected var lineColor = 0
    protected var menuTextColor = 0
    protected var menuTextSize = 0f

    protected var isFullScreen = false
    protected var widthPadding = 0

//    protected var scheduleClickListener: OnScheduleClickListener? = null
//    protected var timeCellClickListener: OnTimeCellClickListener? = null
//    protected var scheduleLongClickListener: OnScheduleLongClickListener? = null

    protected var border: Boolean = false
    protected var xEndLine: Boolean = false
    protected var yEndLine: Boolean = false

//    protected var schedules: ArrayList<ScheduleEntity> = ArrayList()


    constructor(context: Context) : super(context){
        initView(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initView(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        initView(context, attrs)
    }

    private fun initView(context: Context, attrs: AttributeSet?) {

    }

}