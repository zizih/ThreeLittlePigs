package andr.lexibook.mylittlestory.tlps.ui;

import andr.lexibook.mylittlestory.tlps.ui.ViewIml.CustomMenu;
import andr.lexibook.mylittlestory.tlps.ui.ViewIml.CustomMenuItem;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * This is class demonstrates how to use the custom menu helper classes.
 *
 * @author William J Francis (w.j.francis@tx.rr.com)
 * @version 1.0
 * @category Demos
 * @copyright Enjoy!
 */

public class CustomMenuBase extends Activity implements CustomMenu.OnMenuItemSelectedListener {

    /**
     * Some global variables.
     */
    private CustomMenu mMenu;
    public final int ENGLISH = 0;
    public final int FRANCH = 1;
    public final int EUTSCH = 2;
    public final int ESPANOL = 3;
    public final int ITALIANO = 4;
    private View menuView;

    /**
     * Always called when an Android activity launches.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        //create the view
        super.onCreate(savedInstanceState);
        //initialize the menu
        mMenu = new CustomMenu(this, this, getLayoutInflater());
        mMenu.setHideOnSelect(true);
        mMenu.setItemsPerLineInPortraitOrientation(4);
        mMenu.setItemsPerLineInLandscapeOrientation(8);
        //load the menu items
        loadMenuItems();
    }

    /**
     * Snarf the menu key.
     */
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            doMenu();
            return true; //always eat it!
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * Load up our menu.
     */
    private void loadMenuItems() {
        //This is kind of a tedious way to load up the menu items.
        //Am sure there is room for improvement.
        ArrayList<CustomMenuItem> menuItems = new ArrayList<CustomMenuItem>();
        CustomMenuItem cmi = new CustomMenuItem();
        cmi.setCaption(getString(R.string.lang_english));
        cmi.setId(ENGLISH);
        menuItems.add(cmi);
        cmi = new CustomMenuItem();
        cmi.setCaption(getString(R.string.lang_franch));
        cmi.setId(FRANCH);
        menuItems.add(cmi);
        cmi = new CustomMenuItem();
        cmi.setCaption(getString(R.string.lang_eutsch));
        cmi.setId(EUTSCH);
        menuItems.add(cmi);
        cmi = new CustomMenuItem();
        cmi.setCaption(getString(R.string.lang_espanol));
        cmi.setId(ESPANOL);
        menuItems.add(cmi);
        cmi = new CustomMenuItem();
        cmi.setCaption(getString(R.string.lang_italiano));
        cmi.setId(ITALIANO);
        menuItems.add(cmi);
        if (!mMenu.isShowing())
            try {
                mMenu.setMenuItems(menuItems);
            } catch (Exception e) {
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setTitle("Egads!");
                alert.setMessage(e.getMessage());
                alert.show();
            }
    }

    public void setMenuView(View menuView) {
        this.menuView = menuView;
    }

    /**
     * Toggle our menu on user pressing the menu key.
     */
    private void doMenu() {
        if (mMenu.isShowing()) {
            mMenu.hide();
        } else {
            //Note it doesn't matter what widget you send the menu as long as it gets view.
            if (menuView != null)
                mMenu.show(menuView);
        }
    }

    /**
     * For the demo just toast the item selected.
     */
    @Override
    public void MenuItemSelectedEvent(CustomMenuItem selection) {
//        Toast t = Toast.makeText(this, "You selected item #" + Integer.toString(selection.getId()), Toast.LENGTH_SHORT);
//        t.setGravity(Gravity.CENTER, 0, 0);
//        t.show();
    }
}