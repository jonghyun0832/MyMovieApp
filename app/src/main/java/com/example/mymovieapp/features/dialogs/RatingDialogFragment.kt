package com.example.mymovieapp.features.dialogs

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.window.Dialog
import androidx.navigation.fragment.navArgs
import com.example.mymovieapp.R
import com.example.mymovieapp.ui.components.dialog.DialogPopup
import com.example.mymovieapp.ui.components.dialog.Rating
import com.example.mymovieapp.ui.models.buttons.LeadingIconData
import com.example.mymovieapp.ui.models.dialog.DialogButton
import dagger.hilt.android.AndroidEntryPoint

@Composable
fun RatingDialogScreen(
    movieName: String,
    rating: Float,
    action: () -> Unit,
    onDismiss: () -> Unit
) {
    ControlledDismissDialog(
        onDismiss = onDismiss
    ) {
        DialogPopup.Rating(
            movieName = movieName,
            rating = rating,
            buttons = listOf(
                DialogButton.Primary(
                    title = stringResource(R.string.submit),
                    leadingIconData = LeadingIconData(
                        iconDrawable = R.drawable.ic_send,
                        iconContentDescription = R.string.submit
                    )
                ) {
                    action()
                    onDismiss()
                },
                DialogButton.Secondary(stringResource(R.string.cancel)) {
                    onDismiss()
                }
            )
        )
    }
}

//@AndroidEntryPoint
//class RatingDialogFragment : BaseDialogFragment() {
//
//    private val args: RatingDialogFragmentArgs by navArgs()
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
//                    DialogPopup.Rating(
//                        movieName = args.movieName,
//                        rating = args.rating,
//                        buttons = listOf(
//                            DialogButton.Primary(
//                                title = getString(R.string.submit),
//                                leadingIconData = LeadingIconData(
//                                    iconDrawable = R.drawable.ic_send,
//                                    iconContentDescription = R.string.submit
//                                )
//                            ) {
//                                dismiss()
//                            },
//                            DialogButton.Secondary(getString(R.string.cancel)) {
//                                dismiss()
//                            }
//                        )
//                    )
//                }
//            }
//        }
//    }
//}
