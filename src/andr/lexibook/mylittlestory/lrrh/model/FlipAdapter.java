package andr.lexibook.mylittlestory.lrrh.model;

import andr.lexibook.mylittlestory.lrrh.control.PageFactory;
import andr.lexibook.mylittlestory.lrrh.ui.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FlipAdapter extends BaseAdapter {

    private Context ctx;
    private PageFactory pageFactory;
    private String[] pagesKey;

    public interface Callback {
        public void mediaPlay(int page);
    }

    private Callback callback;

    public FlipAdapter(Context context) {
        this.ctx = context;
        pageFactory = PageFactory.getInstance(context);
        pagesKey = ((Activity) context).getResources().getStringArray(R.array.page_index);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public int getCount() {
        return pagesKey.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = pageFactory.getPage(pagesKey[position]).getLayout();
        pageFactory.removePage(position);
        return convertView;
    }
}