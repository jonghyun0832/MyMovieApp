package com.example.mymovieapp.features.dialogs

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.mymovieapp.R
import com.example.mymovieapp.ui.components.dialog.Default
import com.example.mymovieapp.ui.components.dialog.DialogPopup
import com.example.mymovieapp.ui.models.dialog.DialogButton
import com.example.mymovieapp.ui.theme.MyMovieAppTheme

@Composable
fun IMDBDialogScreen(
    action: () -> Unit,
    onDismiss: () -> Unit
) {

//    val themeViewModel: ThemeViewModel = hiltViewModel()
    MyMovieAppTheme() {
        DialogPopup.Default(
            title = stringResource(R.string.imdb_title),
            bodyText = stringResource(R.string.imdb_message),
            buttons = listOf(
                DialogButton.Primary(stringResource(R.string.open)) {
                    action()
                    onDismiss()
                },
                DialogButton.SecondaryBorderless(stringResource(R.string.cancel)) {
                    onDismiss()
                }
            )
        )
    }
}
//
//@AndroidEntryPoint
//class IMDBDialogFragment : BaseDialogFragment() {
//
//    private val args: IMDBDialogFragmentArgs by navArgs()
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        dialog?.apply {
//            isCancelable = true
//            setCanceledOnTouchOutside(true)
//            window?.setBackgroundDrawable(ColorDrawable(requireContext().getColor(android.R.color.transparent)))
//        }
//
//        return ComposeView(requireContext()).apply {
//            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
//            setContent {
//                MovieAppTheme(
//                    themeState = themeViewModel.themeState.collectAsState()
//                ) {
//                    DialogPopup.Default(
//                        title = stringResource(R.string.imdb_title),
//                        bodyText = stringResource(R.string.imdb_message),
//                        buttons = listOf(
//                            DialogButton.Primary(getString(R.string.open)) {
//                                startActivity(
//                                    Intent(
//                                        Intent.ACTION_VIEW,
//                                        Uri.parse(IMDB_BASE_URL + args.url)
//                                    )
//                                )
//                            },
//                            DialogButton.SecondaryBorderless(getString(R.string.cancel)) {
//                                dismiss()
//                            }
//                        )
//                    )
//                }
//            }
//        }
//    }
//}
