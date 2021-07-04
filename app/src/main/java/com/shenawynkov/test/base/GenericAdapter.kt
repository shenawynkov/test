package ae.digitalwise.ecommerce.base

import ae.digitalwise.ecommerce.base.SingleLayoutAdapter
import androidx.lifecycle.LifecycleOwner

open class GenericAdapter(var list: ArrayList<*>, layout:Int, owner: LifecycleOwner?=null) :
    SingleLayoutAdapter(layout,owner){
    override fun getObjForPosition(position: Int): Any {
       return list.get(position)
    }

    override fun getItemCount(): Int {
       return list.size
    }

}