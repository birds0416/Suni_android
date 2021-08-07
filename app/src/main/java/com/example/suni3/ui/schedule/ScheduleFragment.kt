package com.example.suni3.ui.schedule

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.suni3.R
import kotlinx.android.synthetic.main.fragment_schedule.*
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.OutputStream


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
        if (id == R.id.capture) {
            val mbitmap = getScreenShotFromView(my_schedule.rootView)
            try {
                if (mbitmap != null) {
                    //storeScreenShot(myBitmap, "test2.jpg", this@TelecollecteActivity)
                    val extr = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
                    val myPath = File(extr, "test.jpg")
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
            startActivity(intent)
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
//        }

        fos?.use {
            // Finally writing the bitmap to the output stream that we opened
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, it)
//            Toast.makeText(this, "Captured View and saved to Gallery" , Toast.LENGTH_SHORT).show()
        }
    }
}

