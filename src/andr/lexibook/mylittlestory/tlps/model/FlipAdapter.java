package andr.lexibook.mylittlestory.tlps.model;

import andr.lexibook.mylittlestory.tlps.control.BgSrc;
import andr.lexibook.mylittlestory.tlps.control.PageFactory;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.PageView;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class FlipAdapter extends BaseAdapter {

    private Context ctx;
    private PageFactory pageFactory;

    public FlipAdapter(Context context) {
        this.ctx = context;
        pageFactory = PageFactory.getInstance(context);
    }

    @Override
    public int getCount() {
        return pageFactory.getCount();
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
        convertView = pageFactory.getPage(position).getLayout();
        pageFactory.removePage(position);
        BgSrc.getInstance(ctx).Clear();
        return convertView;
    }
}