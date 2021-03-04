[![](https://jitpack.io/v/u-barnwal/MaterialEditTextLibrary.svg)](https://jitpack.io/#u-barnwal/MaterialEditTextLibrary)
# MaterialEditText
Advance EditText with features like required data validation. Built with Material.io components

## Implementation
**Step 1:** Add to project level build.gradle

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

**Step 2:** Add to app level build.gradle

	dependencies {
	    implementation 'com.github.u-barnwal:MaterialEditTextLibrary:VERSION'
	}
## How to use
**Create view**

    <com.isolpro.library.materialedittext.MaterialEditText
      android:id="@+id/metEmail"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      app:met_boxBackgroundColor="@color/white"
      app:met_boxBackgroundMode="outline"
      app:met_enabled="true"
      app:met_errorMessage="Email can't be empty!"
      app:met_hint="Email"
      app:met_inputType="text"
      app:met_lines="1"
      app:met_required="true"
      app:met_text="dummy@domain.com" />

**All the attributes can also be set using their Setter functions**

**Validating EditTexts**  
You need to make to set `required` to true for the fields that you want to validate.

    MaterialEditText metEmail = findViewById(R.id.metEmail);

    MaterialEditText.validateEditTexts(metEmail); // you can pass any no. of MaterialEditTexts here

**Validating with OnError callback**  

    MaterialEditText metEmail = findViewById(R.id.metEmail);

    MaterialEditText.validateEditTexts(met -> {
      Toast.makeText(this, "Some required fields are empty", Toast.LENGTH_LONG).show();
    }, metEmail); // you can pass any no. of MaterialEditTexts here

See [sample app]("./app/src/main")

## Features

 - No need to enable/disabled errors separately
 - Hassle free error handling
 - Validate fields in bulk
 - Define everything right from XML
 - Lesser lines of code
 - Pre-optimized
 - Easy to use
 - Lightweight
