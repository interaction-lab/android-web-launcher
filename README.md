Android launcher application

STEPS TO ADD A NEW ACTIVITY TO THE LAUNCHER:

1. Add an image of size around 320x320px as the logo for that activity, should also contain the name of the activity if there is a need to display that. This image needs to be added to the directory './app/src/main/res/drawable/'

2. Name it 'activity<X>.png' where you should replace <X> with the number of that activity, e.g. 'activity2.png'

3. In './app/src/main/res/layout/content_main.xml', add another image button following the template given there.
	Take care to change the ID of each new imagebutton (the android:id attribute) and the source file for each (the android:src attribute). The source name must match the name of the image in step 1. 

4. If the android:weight attribute of each layout is identical, then all the activities will be given equal space in the horizontal linear layout. Here the layout will have to be adjusted as per the number of activities, for e.g. If there are upto 4 activities, a single row would be fine but for more than that the layout can be done in two rows by nesting the current horizontal linearLayout inside a new vertical linearLayout. 

5. In './app/src/main/res/values/strings.xml' add an entry of the form 
	<string name="url_activityX">YOUR_CUSTOM_URL</string>
as can be seen in that file. 'X' is again the number of the activity you are adding. YOUR_CUSTOM_URL is the URL that that imagebutton must point to.

6. In './app/src/main/java/interactionlab/launcher/MainActivity.java' an ImageButton and its onClickListener have to be created for each activity, which can be done following the comments in that file.
	Note that while creating the ImageButton, in findViewById(R.id.<X>), <X> must match the android:id attribute in step 3.
	Note that while creating the onClickListener, in getResources().getString(R.string.url_activityX) the X must match the number of activity as in step 5.

STEPS TO REMOVE AN ACTIVITY FROM THE LAUNCHER
Undo everything done in the above section.



Right now, this application supports high resolution screens such as those of the Samsung Galaxy View. For better results on lower resolution screens, the images and logo will have to be re-sized, according to the guides available at Google's SDK tutorial website.