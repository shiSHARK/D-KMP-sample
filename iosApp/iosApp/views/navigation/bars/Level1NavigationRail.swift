//
//  Level1NavigationRail.swift
//  iosApp
//
//  Created by Daniele Baroncelli on 24/05/21.
//  Copyright © 2021 orgName. All rights reserved.
//

import SwiftUI
import shared


extension Navigation {

    // this is the left vertical navigation bar for 2-Pane visualization
    // (used by bigger devices in landscape mode)
    
    @ViewBuilder func level1NavigationRail(selectedTab: ScreenIdentifier) -> some View {

        Spacer()
        NavigationRailButton(
            itemLabel: "All Countries",
            iconName: "list.bullet",
            selected: selectedTab.URI==Level1NavigationImpl.allcountries.screenIdentifier.URI,
            onClick: { self.navigateByLevel1Menu(level1NavigationItem: Level1NavigationImpl.allcountries) }
        )
        NavigationRailButton(
            itemLabel: "Favorites",
            iconName: "star.fill",
            selected: selectedTab.URI==Level1NavigationImpl.favoritecountries.screenIdentifier.URI,
            onClick: { self.navigateByLevel1Menu(level1NavigationItem: Level1NavigationImpl.favoritecountries) }
        )
        Spacer()

    }
        
}




struct NavigationRailButton: View {
    var itemLabel : String
    var iconName : String
    var selected : Bool
    var onClick : () -> Void
    
    var body: some View {
        Button(action: { onClick() }) {
            VStack(spacing: 5) {
                Image(systemName: iconName).resizable().scaledToFit().frame(height:15)
                Text(itemLabel).font(Font.footnote)
            }
            .padding(.top, 25)
            .padding(.bottom, 25)
            .foregroundColor(selected ? .white : linkColor)
        }
    }
}
