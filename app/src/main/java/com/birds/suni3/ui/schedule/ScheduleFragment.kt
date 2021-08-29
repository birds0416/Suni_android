package com.birds.suni3.ui.schedule

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.os.Environment
import android.preference.PreferenceManager
import android.provider.MediaStore
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment
import com.birds.suni3.R
import com.github.tlaabs.timetableview.Schedule
import com.github.tlaabs.timetableview.TimetableView
import kotlinx.android.synthetic.main.fragment_schedule.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.OutputStream


class ScheduleFragment : Fragment() {

    private var timetable: TimetableView? = null
    private var mode = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View= inflater.inflate(R.layout.fragment_schedule, container, false)
        timetable = v.findViewById(R.id.timetable)
        initView()
        loadSavedData()
        return v
    }

    /* Enable Buttons */

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    private fun initView() {
        timetable!!.setOnStickerSelectEventListener { idx, schedules ->
            timetable!!.remove(idx)
            saveByPreference(timetable!!.createSaveData())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_ADD_COURSE -> if (resultCode == ManualFragment.RESULT_OK_ADD) {
                val item = data?.getSerializableExtra("schedules") as ArrayList<Schedule>
                timetable!!.add(item)
                saveByPreference(timetable!!.createSaveData())
            } else if (resultCode == CourseFragment.RESULT_OK_ADD) {
                val item = data?.getSerializableExtra("schedules") as ArrayList<Schedule>
                val item2 = data?.getSerializableExtra("schedules2") as ArrayList<Schedule>
//                val item3 = data?.getSerializableExtra("schedules3") as ArrayList<Schedule>
                timetable!!.add(item)
                timetable!!.add(item2)
//                timetable!!.add(item3)
                saveByPreference(timetable!!.createSaveData())
            } else if (resultCode == PopupActivity.RESULT_OK_DELETE) {
                val idx = data?.getIntExtra("del_idx", -1)
                if (idx != null) {
                    timetable!!.remove(idx)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_schedule, menu)
        menu.findItem(R.id.before).setVisible(false)
        menu.findItem(R.id.save).setVisible(false)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.capture) {
            val mbitmap = getScreenShotFromView(my_schedule.rootView)
            try {
                if (mbitmap != null) {
                    //storeScreenShot(myBitmap, "test2.jpg", this@TelecollecteActivity)
                    val extr = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                    val myPath = File(extr, "capture.jpg")
                    var fos: FileOutputStream? = null
                    try {
                        fos = FileOutputStream(myPath)
                        mbitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
                        fos!!.flush()
                        fos!!.close()
                        MediaStore.Images.Media.insertImage(activity?.contentResolver, mbitmap,
                                "Screen", "screen")
                        Toast.makeText(context, "Schedule captured and saved to gallery!", Toast.LENGTH_SHORT).show()
                    } catch (e: FileNotFoundException) {
                        // TODO Auto-generated catch block
                        e.printStackTrace()
                    } catch (e: Exception) {
                        // TODO Auto-generated catch block
                        e.printStackTrace()
                    }
                }
            } catch (e: java.lang.Exception) {
                Log.e("BLABLA", "Error ::" + e.message)
            }
        }
        if (id == R.id.add_course) {
            // Move to next fragment
            val intent = Intent(activity, AddCourseActivity::class.java)
            intent.putExtra("mode", REQUEST_ADD_COURSE)
            startActivityForResult(intent, REQUEST_ADD_COURSE)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getScreenShotFromView(v: View): Bitmap? {
        // create a bitmap object
        var screenshot: Bitmap? = null
        try {
            // inflate screenshot object
            // with Bitmap.createBitmap it
            // requires three parameters
            // width and height of the view and
            // the background color
            screenshot = Bitmap.createBitmap(v.measuredWidth, v.measuredHeight, Bitmap.Config.ARGB_8888)
            // Now draw this bitmap on a canvas
            val canvas = Canvas(screenshot)
            v.draw(canvas)
        } catch (e: Exception) {
            Log.e("GFG", "Failed to capture screenshot because:" + e.message)
        }
        // return the bitmap
        return screenshot
    }

    // this method saves the image to gallery
    private fun saveMediaToStorage(bitmap: Bitmap) {
        // Generating a file name
        val filename = "${System.currentTimeMillis()}.jpg"

        // Output stream
        var fos: OutputStream? = null

        val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        val image = File(imagesDir, filename)
        fos = FileOutputStream(image)

        fos?.use {
            // Finally writing the bitmap to the output stream that we opened
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
        }
    }

    private fun saveByPreference(data: String) {
        val mPref = requireActivity().getPreferences(0)
        val editor = mPref.edit()
        editor.putString("timetable", data)
        editor.commit()
    }

    private fun loadSavedData() {
        timetable!!.removeAll()
        val mPref = requireActivity().getPreferences(0)
        val savedData = mPref.getString("timetable", "")
        if (savedData == null && savedData == "") {
            return
        } else {
            saveByPreference(timetable!!.createSaveData())
            return timetable!!.load(savedData)
        }
        Toast.makeText(this.requireContext(), "loaded!", Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val REQUEST_ADD_COURSE = 1
        const val REQUEST_ADD_MANUAL = 2
        const val REQUEST_DELETE = 3
    }

}

