package link.ppia.shoppingcart1.adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import link.ppia.shoppingcart1.databinding.ShopRowBinding;
import link.ppia.shoppingcart1.models.Product;

public class ShopListAdapter extends ListAdapter<Product,ShopListAdapter.ShopViewHolder> {

    ShopInterface shopInterface;

    public ShopListAdapter(ShopInterface shopInterface) {
        super(Product.itemCallback);
        this.shopInterface = shopInterface;

    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //since we are using a data binding here, we need to say:
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ShopRowBinding shopRowBinding = ShopRowBinding.inflate(layoutInflater, parent, false);
        shopRowBinding.setShopInterface(shopInterface);
        return new ShopViewHolder(shopRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        Product product = getItem(position);
        //this method setProduct will automatically be generated by databinding because of the <data> variable which has a name of product and the type is product in shop_row fragment.
        holder.shopRowBinding.setProduct(product);
    }


    class ShopViewHolder extends RecyclerView.ViewHolder {

        ShopRowBinding shopRowBinding;

        public ShopViewHolder(ShopRowBinding binding) {
            //provides the actual view that is in the super method
            super(binding.getRoot());
            this.shopRowBinding = binding;

        }
    }
    /*
    *We'll create an interface inside the Shoplistadapter to handle the events adding the item to the cart or
    * going to the product detail fragment.
     * */

    public interface ShopInterface{
        void addItem(Product product);
        void onItemClick(Product product);



    }

}