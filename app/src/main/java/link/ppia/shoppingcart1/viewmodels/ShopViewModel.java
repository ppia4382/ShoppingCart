package link.ppia.shoppingcart1.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import link.ppia.shoppingcart1.models.Product;
import link.ppia.shoppingcart1.repositories.CartRepo;
import link.ppia.shoppingcart1.repositories.ShopRepo;

public class ShopViewModel extends ViewModel {

    ShopRepo shopRepo = new ShopRepo();
    CartRepo cartRepo = new CartRepo();

    MutableLiveData<Product>mutableProduct=new MutableLiveData<>();

    public LiveData<List<Product>> getProducts(){return shopRepo.getProducts();}

    public void setProduct(Product product){
        mutableProduct.setValue(product);
    }

    public LiveData<Product>getProduct(){
        return mutableProduct;
    }

}
