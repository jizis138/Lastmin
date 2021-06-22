package ru.vsibi.presentation.helpers

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import ru.vsibi.presentation.models.PersonalDataModel
import ru.vsibi.presentation.models.SearchModel
import ru.vsibi.presentation.models.flight.FlightResponse
import ru.vsibi.presentation.screens.tours.main.TourModel
import ru.vsibi.presentation.screens.login.LoginFragmentDirections
import ru.vsibi.presentation.screens.login.emailVariant.createPassword.CreatePassFragmentDirections
import ru.vsibi.presentation.screens.login.emailVariant.email.LoginEmailFragmentDirections
import ru.vsibi.presentation.screens.login.emailVariant.forgotPassword.ForgotPassFragmentDirections
import ru.vsibi.presentation.screens.login.emailVariant.password.LoginPasswordFragmentDirections
import ru.vsibi.presentation.screens.main.MainFragmentDirections
import ru.vsibi.presentation.screens.profile.coTravellers.CoTravallersFragmentDirections
import ru.vsibi.presentation.screens.profile.main.ProfileFragmentDirections
import ru.vsibi.presentation.screens.profile.orders.info.OrdersDetailFragmentDirections
import ru.vsibi.presentation.screens.profile.orders.main.OrdersFragmentDirections
import ru.vsibi.presentation.screens.saved.SavedFragmentDirections
import ru.vsibi.presentation.screens.search.main.SearchFragmentDirections
import ru.vsibi.presentation.screens.tours.info.ToursInfoFragment
import ru.vsibi.presentation.screens.tours.info.ToursInfoFragmentDirections
import ru.vsibi.presentation.screens.tours.info.flights.main.FlightsListFragmentDirections
import ru.vsibi.presentation.screens.tours.main.ToursFragmentDirections
import ru.vsibi.presentation.screens.tours.purchase.PurchaseFormFragmentDirections

class Router {

    companion object {
        val instance = Router()
    }

    var parentNavController: NavController? = null
    var parentNavHostFragment: NavHostFragment? = null
    var childNavHostFragment: NavHostFragment? = null
    var childNavController: NavController? = null

    fun navigateToTravellers() {
        childNavController?.navigate(SearchFragmentDirections.actionSearchFragmentToTravellersFragment())
    }

    fun navigateToLogin() {
        parentNavController?.navigate(MainFragmentDirections.actionMainFragmentToLoginFragment())
    }

    fun navigateToHotelsInfo(hotelsModel: TourModel) {
        childNavController?.navigate(ToursFragmentDirections.actionHotelsFragmentToHotelsInfoFragment(hotelsModel))
    }

    fun navigateHotels(searchModel: SearchModel) {
        childNavController?.navigate(SearchFragmentDirections.actionSearchFragmentToHotelsFragment(searchModel))
    }

    fun navigatePurchaseForm(hotelsModel: TourModel) {
        childNavController?.navigate(ToursInfoFragmentDirections.actionHotelsInfoFragmentToPurchaseFormFragment(hotelsModel))
    }

    fun navigateToLoginWithEmail(isLogin: Boolean) {
        val directions = LoginFragmentDirections.actionLoginFragmentToLoginEmailFragment()
        directions.isLogin = isLogin
        parentNavController?.navigate(directions)
    }

    fun navigateToLoginPassword(data: String) {
        parentNavController?.navigate(LoginEmailFragmentDirections.actionLoginEmailFragmentToLoginPasswordFragment(data))
    }

    fun navigateToMainFromEmailLogin() {
        parentNavController?.navigate(LoginPasswordFragmentDirections.actionLoginPasswordFragmentToMainFragment())
    }

    fun reopenApp() {
        parentNavController?.navigate(MainFragmentDirections.actionMainFragmentSelf())
    }

    fun navigateToCreatePassFromForgot() {
        parentNavController?.navigate(ForgotPassFragmentDirections.actionForgotPassFragmentToCreatePassFragment())
    }

    fun navigateForgotPass(email: String) {
        parentNavController?.navigate(
            LoginPasswordFragmentDirections.actionLoginPasswordFragmentToForgotPassFragment(
                email
            )
        )
    }

    fun navigateToMainFromCreatePass() {
        parentNavController?.navigate(CreatePassFragmentDirections.actionCreatePassFragmentToMainFragment())
    }

    fun navigateToMyOrders() {
        childNavController?.navigate(ProfileFragmentDirections.actionProfileFragmentToOrdersFragment())
    }

    fun navigateToOrdersDetail(hotel: TourModel) {
        childNavController?.navigate(OrdersFragmentDirections.actionOrdersFragmentToOrdersDetailFragment(hotel))
    }

    fun navigateToOrdersDetailFromSaved(hotel: TourModel) {
        childNavController?.navigate(SavedFragmentDirections.actionSavedFragmentToHotelsInfoFragment(hotel))
    }

    fun navigateToTicket() {
        childNavController?.navigate(OrdersDetailFragmentDirections.actionOrdersDetailFragmentToTicketFragment())
    }

    fun navigateTourMore(tour: TourModel?) {
        if (tour == null) return
        childNavController?.navigate(ToursInfoFragmentDirections.actionHotelsInfoFragmentToTourMoreFragment(tour))
    }

    fun navigateToFlightDetails() {
        childNavController?.navigate(ToursInfoFragmentDirections.actionTourInfoFragmentToFlightsListFragment())
    }

    fun navigateToFlightInfo(fligths: FlightResponse) {
        childNavController?.navigate(FlightsListFragmentDirections.actionFlightsListFragmentToFlightsInfoFragment(fligths))
    }

    fun navigateToPersonalData(){
        childNavController?.navigate(ProfileFragmentDirections.actionProfileFragmentToPersonalDataFragment(null))
    }

    fun navigateToCoTravellers() {
        childNavController?.navigate(ProfileFragmentDirections.actionProfileFragmentToCoTravallersFragment())
    }

    fun navigateToPersonalDataFromCoTravellers(person: PersonalDataModel?) {
        childNavController?.navigate(CoTravallersFragmentDirections.actionCoTravallersFragmentToPersonalDataFragment(person))
    }

    fun navigateToChangePass() {
        childNavController?.navigate(ProfileFragmentDirections.actionProfileFragmentToChangePasswordFragment())
    }

    fun navigateToCreatePassFromSignup(data: String) {
        parentNavController?.navigate(LoginEmailFragmentDirections.actionLoginEmailFragmentToCreatePassFragment())
    }

    fun navigateToPersonalDataFromPurchaseForm(person: PersonalDataModel) {
        childNavController?.navigate(PurchaseFormFragmentDirections.actionPurchaseFormFragmentToPersonalDataFragment(person))
    }

    fun navigateToursSettings() {
        childNavController?.navigate(ToursFragmentDirections.actionHotelsFragmentToToursSettingsFragment())
    }


}