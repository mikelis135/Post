This is the extension function here in a typical Utils helper class



    object Utils {


     fun FragmentActivity.goto(fragment: Fragment) {
   
        this.supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.container_body, fragment).addToBackStack("")
                .commit()
                
       }

     fun AppCompatActivity.goto(fragment: Fragment, tag: String = "") {
        this.supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out, R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.container_body, fragment, tag).addToBackStack("")
                .commit()
     }
    
    }
    
  You can use any animation for the fragment animations
    
  https://github.com/mikelis135/Post/tree/master/app/src/main/res
  check this directory for the animation files used here
    
    
    How to use in Activity
    this.goto(yourFragmentInstance)
    
    How to use in Fragment
    requireActivity().goto(yourFragmentInstance)
   
