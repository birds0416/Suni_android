package com.example.suni3.ui.schedule

import android.content.ContentResolver
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.AttributeSet
import android.util.Log
import android.view.*
import android.widget.Button
import android.widget.CalendarView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.suni3.AddCourseActivity
import com.example.suni3.MainActivity
import com.example.suni3.R
import com.github.tlaabs.timetableview.*
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream
import java.lang.Exception
import java.util.jar.Manifest
import com.github.tlaabs.*
import com.github.tlaabs.timetableview.Schedule
import com.github.tlaabs.timetableview.TimetableView
import kotlinx.android.synthetic.main.fragment_schedule.*
import java.io.FileNotFoundException
import kotlin.concurrent.fixedRateTimer

class ScheduleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v: View= inflater.inflate(R.layout.fragment_schedule, container, false)

        return v
    }

    /* Enable Buttons */

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_schedule, menu)
        menu.findItem(R.id.before).setVisible(false)
        menu.findItem(R.id.save).setVisible(false)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.capture){
            // Screen Capture
//            my_schedule.post(Runnable {
//                val mbitmap = getScreenShotFromView(my_schedule.rootView)
//                Toast.makeText(activity, "Schedule Captured!", Toast.LENGTH_SHORT).show()
//                try {
//                    if (mbitmap != null){
//                        //store screen shot of the bitmap
//                        val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
//                        val myPath = File(dir, "screen_shot.jpg")
//                        var fos: FileOutputStream? = null
//                        try {
//                            fos = FileOutputStream(myPath)
//                            mbitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
//                            fos!!.flush()
//                            fos!!.close()
//                            MediaStore.Images.Media.insertImage(activity?.contentResolver, mbitmap, "Screen", "screen")
//                        } catch (e: FileNotFoundException) {
//                            e.printStackTrace()
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                        }
//                    }
//                } catch (e: java.lang.Exception) {
//                    Log.e("exception", "Error ::" + e.message)
//                }
//            })
        }
        if (id == R.id.add_course){
            // Move to next fragment
            val intent = Intent(activity, AddCourseActivity::class.java)
            startActivity(intent)
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getScreenShotFromView(v: View): Bitmap? {
        //create a bitmap object
        var screenshot: Bitmap? = null
        try {
            if (v != null) {
                screenshot = Bitmap.createBitmap(v.measuredWidth, v.measuredHeight, Bitmap.Config.ARGB_8888)
                val canvas = Canvas(screenshot)
                v.draw(canvas)
            }
        } catch (e: Exception) {
            Log.e("Fail", "Failed to capture screenshot because:" + e.message)
        }
        return screenshot
    }

//    private fun saveMediaToStorage(bitmap: Bitmap) {
//        // Generating a file name
//        val filename = "${System.currentTimeMillis()}.jpg"
//
//        // Output stream
//        var fos: OutputStream? = null
//
//        // For devices runnig android >= Q
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            // getting the contentResolver
//            this.contentResolver?.also { resolver ->
//
//                // content resolver will process the content values
//                val contentValues = ContentValues().apply {
//
//                    // putting file information in content values
//                    put(MediaStore.MediaColumns.DISPLAY_NAME, filename)
//                    put(MediaStore.MediaColumns.MIME_TYPE, "image/jpg")
//                    put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_PICTURES)
//                }
//
//                val imageURi : Uri? = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
//
//                fos = imageURi?.let { resolver.openOutputStream(it) }
//            }
//        } else {
//            val imagesDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
//            val image = File(imagesDir, filename)
//            fos = FileOutputStream(image)
//        }
//
//        fos?.use {
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
//            Toast.makeText(activity, "Captured schedule and saved to Gallery", Toast.LENGTH_SHORT).show()
//        }
//    }
}