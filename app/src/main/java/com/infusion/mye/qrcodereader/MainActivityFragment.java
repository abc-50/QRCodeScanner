package com.infusion.mye.qrcodereader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.infusion.mye.qrcodereader.model.Product;

import java.io.InputStream;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

//    TextView uuidView;
    TextView nameView;
    TextView priceView;
    ImageView productImgView;
    Product product;

    public MainActivityFragment(Product product) {
        this.product=product;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //uuidView = (TextView) view.findViewById(R.id.product_id);
        nameView = (TextView) view.findViewById(R.id.product_name);
        priceView = (TextView) view.findViewById(R.id.product_price);
        productImgView = (ImageView) view.findViewById(R.id.product_picture);

        updateProduct(this.product);
    }

    public void updateProduct(Product product) {
        this.product=product;

//        uuidView.setText(product.getId().toString());
//        uuidView.invalidate();
        nameView.setText(product.getName());
        nameView.invalidate();
        priceView.setText(Double.toString(product.getPrice()));
        priceView.invalidate();
        new DownloadImageTask(productImgView)
                .execute(product.getProductImgUrl().toString());
    }


    protected int getLayoutId() {
        return R.layout.fragment_product_info;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
            bmImage.invalidate();
        }
    }
}
