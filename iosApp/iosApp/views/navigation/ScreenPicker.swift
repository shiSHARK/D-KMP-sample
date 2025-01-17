//
//  ScreenPicker.swift
//
//  Created by Daniele Baroncelli on 06/05/2021.
//
//

import SwiftUI
import shared

extension Navigation {
    
    @ViewBuilder func screenPicker(_ sId: ScreenIdentifier) -> some View {
        
        VStack {
        
            switch sId.screen.asString {
            
            case ScreenImpl.countrieslist.asString :
                CountriesListScreen(
                    countriesListState: self.stateProvider.getToCast(screenIdentifier: sId) as! CountriesListState,
                    onListItemClick: { name in self.navigate(ScreenImpl.countrydetail, CountryDetailParams(countryName: name)) },
                    onFavoriteIconClick: { name in self.events.selectFavorite(countryName: name) }
                )
                
            case ScreenImpl.countrydetail.asString :
                CountryDetailScreen(
                    countryDetailState: self.stateProvider.getToCast(screenIdentifier: sId) as! CountryDetailState
                )
                
            default:
                EmptyView()
            }
            
        }
    }
    
    
    @ViewBuilder func twoPaneDefaultDetail(_ sId: ScreenIdentifier) -> some View {
        
        switch sId.screen.asString {

        case ScreenImpl.countrieslist.asString: CountriesListTwoPaneDefaultDetail()

        default:
            EmptyView()
        }
    }
    
    
}

