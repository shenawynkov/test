package ae.digitalwise.ecommerce.base

import ae.digitalwise.mybank.base.MyBaseAdapter
import androidx.lifecycle.LifecycleOwner


abstract class SingleLayoutAdapter(private val layoutId: Int, lifeowner: LifecycleOwner?) : MyBaseAdapter(lifeowner) {

    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }
}
