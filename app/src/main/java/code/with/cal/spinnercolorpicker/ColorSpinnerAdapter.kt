package code.with.cal.spinnercolorpicker

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ColorSpinnerAdapter(context: Context, list : List<ColorObject>)
    : ArrayAdapter<ColorObject>(context, 0 , list)
{
    private var layoutInflater = LayoutInflater.from(context)

    @SuppressLint("ViewHolder", "InflateParams")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        val view: View = layoutInflater.inflate(R.layout.color_spinner_bg, null, true)
        return view(view, position)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View
    {
        var cv = convertView
        if(cv == null)
            cv = layoutInflater.inflate(R.layout.color_spinner_item, parent, false)
        return view(cv!!, position)
    }

    private fun view(view: View, position: Int): View
    {
        val colorObject : ColorObject = getItem(position) ?: return view

        val colorNameItem = view.findViewById<TextView>(R.id.colorName)
        val colorHexItem = view.findViewById<TextView>(R.id.colorHex)
        val colorNameBG = view.findViewById<TextView>(R.id.colorNameBG)
        val colorBlob = view.findViewById<View>(R.id.colorBlob)

        colorNameBG?.text = colorObject.name
        colorNameBG?.setTextColor(Color.parseColor(colorObject.contrastHexHash))

        colorNameItem?.text = colorObject.name
        colorHexItem?.text = colorObject.hex

        colorBlob?.background?.setTint(Color.parseColor(colorObject.hexHash))

        return view
    }
}













