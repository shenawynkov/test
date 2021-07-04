package ae.digitalwise.mybank.base
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner

import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.RecyclerView


abstract class MyBaseAdapter(val lifecycleOwner: LifecycleOwner?) : RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
            layoutInflater, viewType, parent, false
        )
        return MyViewHolder(binding,lifecycleOwner)
    }

    override fun onBindViewHolder(
        holder: MyViewHolder,
        position: Int
    ) {
        val obj = getObjForPosition(position)
        holder.bind(obj)
        if(lifecycleOwner!=null)
        {

            holder.binding.lifecycleOwner=lifecycleOwner

        }
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    protected abstract fun getObjForPosition(position: Int): Any

    protected abstract fun getLayoutIdForPosition(position: Int): Int

}

class MyViewHolder(val binding: ViewDataBinding,val lifecycleOwner: LifecycleOwner?) : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: Any) {

    binding.setVariable(BR.obj, obj)
        binding.executePendingBindings()

    }


}