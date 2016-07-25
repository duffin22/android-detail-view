package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();
        int position = intent.getIntExtra("id",0);

        ShoppingSQLiteOpenHelper db = ShoppingSQLiteOpenHelper.getInstance(getApplicationContext());
        Cursor cursor = db.getShoppingList();

        cursor.moveToFirst();
        cursor.moveToPosition(position);
        String name = (String) cursor.getString(cursor.getColumnIndexOrThrow(ShoppingSQLiteOpenHelper.COL_ITEM_NAME));
        String description = (String) cursor.getString(cursor.getColumnIndexOrThrow(ShoppingSQLiteOpenHelper.COL_ITEM_DESCRIPTION));
        String price = (String) cursor.getString(cursor.getColumnIndexOrThrow(ShoppingSQLiteOpenHelper.COL_ITEM_PRICE));
        String type = (String) cursor.getString(cursor.getColumnIndexOrThrow(ShoppingSQLiteOpenHelper.COL_ITEM_TYPE));

        TextView nameView = (TextView) findViewById(R.id.name);
        TextView descriptionView = (TextView) findViewById(R.id.description);
        TextView priceView = (TextView) findViewById(R.id.price);
        TextView typeView = (TextView) findViewById(R.id.type);

        nameView.setText(name);
        descriptionView.setText(description);
        priceView.setText(price);
        typeView.setText(type);

    }
}
