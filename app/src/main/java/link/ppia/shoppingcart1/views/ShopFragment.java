package link.ppia.shoppingcart1.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import link.ppia.shoppingcart1.R;
import link.ppia.shoppingcart1.adapters.ShopListAdapter;
import link.ppia.shoppingcart1.databinding.FragmentShopBinding;
import link.ppia.shoppingcart1.models.Product;
import link.ppia.shoppingcart1.viewmodels.ShopViewModel;

public class ShopFragment extends Fragment implements ShopListAdapter.ShopInterface {

    private static final String TAG = "ShopFragment";
    FragmentShopBinding fragmentShopBinding;
    private ShopListAdapter shopListAdapter;
    private ShopViewModel shopViewModel;
    private NavController navController;


    public ShopFragment() {
        // Required empty public constructor
    }

      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentShopBinding = FragmentShopBinding.inflate(inflater,container,false);
        return fragmentShopBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //ShopListAdapterをinitializeする
        shopListAdapter = new ShopListAdapter(this);
        //we can use the fragmentshopbinding to get the recyclerview that's inside this fragment
        fragmentShopBinding.shopRecycleView.setAdapter(shopListAdapter);
        //to have a divider in between each products in the gridview
        fragmentShopBinding.shopRecycleView.addItemDecoration(new DividerItemDecoration(requireContext(),
                DividerItemDecoration.VERTICAL));
        fragmentShopBinding.shopRecycleView.addItemDecoration(new DividerItemDecoration(requireContext(),
                DividerItemDecoration.HORIZONTAL));


        //now let's initialize the shopViewModel
        shopViewModel= new ViewModelProvider(requireActivity()).get(ShopViewModel.class);
        shopViewModel.getProducts().observe(getViewLifecycleOwner(), new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                shopListAdapter.submitList(products);
            }
        });

        navController = Navigation.findNavController(view);

    }



    @Override
    public void addItem(Product product) {

    }

    @Override
    public void onItemClick(Product product) {
        Log.d(TAG, "onItemClick: "+product.toString());
        shopViewModel.setProduct(product);
        navController.navigate(R.id.action_shopFragment_to_productDetailFragment);

    }
}