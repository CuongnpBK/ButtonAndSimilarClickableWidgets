package com.example.nguye.buttonandsimilarclickablewidgets;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonActivity extends Activity {
    private String mButtonMessageTemplate;
    private String mImageButtonMessageTemplate;
    private String mToggleButtonMessageTemplate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons);
        mButtonMessageTemplate = getString(R.string.button_message_template);
        mImageButtonMessageTemplate = getString(R.string.image_button_message_template);
        RadioGroup radioGroup =
                (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroupInfo());
        mToggleButtonMessageTemplate = getString(R.string.toggle_button_message_template);
    }

    public void showImageButton1Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_1_image);
    }

    public void showImageButton2Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_2_image);
    }

    public void showImageButton3Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_3_image);
    }

    public void showImageButton4Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_4_image);
    }

    public void showImageButton5Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_5_image);
    }

    public void showImageButton6Info(View clickedImageButton) {
        showImageButtonInfo(R.string.image_button_6_image);
    }

    public void showImageButtonInfo(int imageID) {
        String image = getString(imageID);
        String message = String.format(mImageButtonMessageTemplate, image);
        showToast(message);
    }

    public void showButtonText(View clickedButton) {
        Button button = (Button) clickedButton;
        CharSequence text = button.getText();
        String message = String.format(mButtonMessageTemplate, text);
        showToast(message);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private class RadioGroupInfo implements RadioGroup.OnCheckedChangeListener {
        private RadioButton mLastChecked;
        private String mNewSelectionMessageTemplate;
        private String mChangedSelectionMessageTemplate;

        public RadioGroupInfo() {
            mNewSelectionMessageTemplate =
                    getString(R.string.new_selection_message_template);
            mChangedSelectionMessageTemplate =
                    getString(R.string.changed_selection_message_template);
        }

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            RadioButton newChecked =
                    (RadioButton) findViewById(checkedId);
            String message;
            if (mLastChecked == null) { // No previous selection
                message = String.format(mNewSelectionMessageTemplate,
                        newChecked.getText());
            } else {
                message = String.format(mChangedSelectionMessageTemplate,
                        newChecked.getText(),
                        mLastChecked.getText());
            }
            mLastChecked = newChecked;
            showToast(message);
        }
    }
    public void showToggleButtonInfo(View clickedToggleButton) {
        ToggleButton toggleButton =
                (ToggleButton)clickedToggleButton;
        String status;
        if (toggleButton.isChecked()) {
            status = "ON";
        } else {
            status = "OFF";
        }
        CharSequence label = toggleButton.getText();
        String message =
                String.format(mToggleButtonMessageTemplate,
                        status, label);
        showToast(message);
    }

}
