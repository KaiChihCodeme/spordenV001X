package com.robot.asus.ZenboHelloWorld.Adapter;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.robot.asus.ZenboHelloWorld.R;

public class SportPackageCategoryAdapter extends RecyclerView.Adapter<SportPackageCategoryAdapter.ViewHolder>{
    //使用此二變數儲存類別資料
    private String[] names;
    private int[] imgs;
    private String[] intros;
    private Listener listener;

    // 加入介面，讓使用者按下卡片視區時能呼叫onClick
    public interface Listener {
        void onClick(int position);
    }

    //activities and fragment會使用此方法來註冊listener
    public void setListener(Listener listener){
        this.listener = listener;
    }

    //建立view holder
    public class ViewHolder extends RecyclerView.ViewHolder{
        // 定義各個資料項目使用的視區

        //recyclerview需顯示cardview，所以宣告viewHolder裡有cardview。若要在recycler視區內顯示別的類型的資料須在此處定義
        private CardView cardView;

        public ViewHolder(CardView itemView) {
            super(itemView);
            //sport_category = (TextView) itemView.findViewById(R.id.sport_category_name);
            //sport_category_img = (ImageView) itemView.findViewById(R.id.sport_category_imgbtn);
            cardView = itemView;
        }
    }

    //用adapter建構是把資料傳給兩個變數
    public SportPackageCategoryAdapter(String[] names, int[] imgs, String[] intros) {
        this.names = names;
        this.imgs = imgs;
        this.intros = intros;
    }

    //視區建立新view holder時呼叫這邊(使用cardview版面)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // 建立項目使用的畫面配置元件，指定viewholder需使用哪個版面(card) (哲嘉是用View，書寫CardView)
        // 用layoutinflater將版面轉為cardview
        CardView cv = (CardView) LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.cardview_sport_package_category, viewGroup, false);
        // 建立與回傳包裝好的畫面配置元件
        return new ViewHolder(cv);
    }

    //當recycler視區想要使用或重複使用view holder來顯示新資料時會呼叫此方法(且將資料放進去view相對應位置裡面)
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        final CardView cardView = viewHolder.cardView;
        //設定imgview
        ImageView imageView = (ImageView)cardView.findViewById(R.id.sport_package_category_img);
        //設定為陣列中(drawable內)第幾個照片
        Drawable drawable = ContextCompat.getDrawable(cardView.getContext(), imgs[i]);
        //將那張照片設定在imgview
        imageView.setImageDrawable(drawable);
        imageView.setContentDescription(names[i]);

        //設定textview，並將第幾個name設定上去
        TextView textViewName = (TextView)cardView.findViewById(R.id.sport_package_category_name);
        textViewName.setText(names[i]);

        //設定textview，並將第幾個intro設定上去
        TextView textViewIntro = (TextView)cardView.findViewById(R.id.sport_package_category_intro);
        textViewIntro.setText(intros[i]);

        //讓cardview可以被按下並啟動別的(將listener加入cardview)
        cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                /*Intent intent = new Intent(cardView.getContext(), SportList.class);
                //這邊到時候可以參照書來寫該類別所產生的清單(傳id過去來過濾清單)
                // intent.putExtra(SportList.Extra_ID, i);
                cardView.getContext().startActivity(intent);*/

                //當cardview被按下時呼叫listener.onClick()
                if (listener != null){
                    listener.onClick(i);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return names.length;
    }
}
