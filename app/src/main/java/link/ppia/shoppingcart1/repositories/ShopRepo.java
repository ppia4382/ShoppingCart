package link.ppia.shoppingcart1.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import link.ppia.shoppingcart1.models.Product;

public class ShopRepo {

  /*Whether you are using RoomDatabase or Retrofit, or any other method inside the app,
  no matter what you're using to load your data, they should be placed here in the repository class.

  First, we want to have a list of products that is mutable live data.
  ***/

    private MutableLiveData<List<Product>> mutableProductList;

    //this is another method which return type is a live data.
    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null){
            mutableProductList = new MutableLiveData<>();
            loadProducts();

        }
        return mutableProductList;
    }

    private void loadProducts(){
        List<Product>productList = new ArrayList<>();

        //to add products to the productlist
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2016/12/09/11/33/smartphone-1894723_960_720.jpg"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2014/04/05/09/30/tablet-314153__340.png"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2013/07/12/18/39/smartphone-153650__340.png"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2015/01/20/12/51/mobile-605422__340.jpg"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2016/12/09/11/33/smartphone-1894723_960_720.jpg"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2014/04/05/09/30/tablet-314153__340.png"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2013/07/12/18/39/smartphone-153650__340.png"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2015/01/20/12/51/mobile-605422__340.jpg"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2016/12/09/11/33/smartphone-1894723_960_720.jpg"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2014/04/05/09/30/tablet-314153__340.png"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2013/07/12/18/39/smartphone-153650__340.png"));
        productList.add(new Product(UUID.randomUUID(),toString(),"iMac21",1299, true, "https://cdn.pixabay.com/photo/2015/01/20/12/51/mobile-605422__340.jpg"));




        mutableProductList.setValue(productList);

    }

}
