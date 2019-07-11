package example.com.pkmnavidemo4.classes;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import example.com.pkmnavidemo4.R;

public class TestRecycleViewAdapter extends RecyclerView.Adapter<TestRecycleViewAdapter.ViewHolderA> {
    private Context mContext;
    private List<String> mList;
    public TestRecycleViewAdapter(Context context, List<String> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public ViewHolderA onCreateViewHolder(ViewGroup parent, int viewType) {
        //此处动态加载ViewHolder的布局文件并返回holder
        View view = LayoutInflater.from(mContext).inflate(R.layout.recycleview_item, parent, false);
        ViewHolderA holderA = new ViewHolderA(view);
        return holderA;
    }

    @Override
    public void onBindViewHolder(ViewHolderA holder, final int position) {
        //此处设置Item中view的数据
        holder.mTextView.setText(mList.get(position));
        holder.mTextView.setBackgroundResource(ElfSourceController.getBackground(position));
        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "elf" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //生成的item的数量
        return mList.size();
    }

    //Item的ViewHolder以及item内部布局控件的id绑定
    class ViewHolderA extends RecyclerView.ViewHolder{

        TextView mTextView;
        public ViewHolderA(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.recycle_textview);
        }
    }
}