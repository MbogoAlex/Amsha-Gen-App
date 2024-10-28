package com.generation.amsha.ui.auth.registration

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.generation.amsha.ui.reuseCompose.PasswordFieldComposable
import com.generation.amsha.ui.reuseCompose.TextFieldComposable
import com.generation.amsha.ui.theme.AmshaTheme
import com.generation.amsha.utils.screenFontSize
import com.generation.amsha.utils.screenHeight
import com.generation.amsha.utils.screenWidth

@Composable
fun RegistrationScreenComposable(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .safeDrawingPadding()
    ) {
        RegistrationScreen()
    }
}

@Composable
fun RegistrationScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = screenWidth(x = 16.0),
                vertical = screenHeight(x = 16.0)
            )
            .verticalScroll(rememberScrollState())
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Previous screen"
            )
        }
        Text(
            text = "Join the Amsha Generation",
            fontWeight = FontWeight.Bold,
            fontSize = screenFontSize(x = 20.0).sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        Text(
            text = "Join us today amd start saving!",
            fontSize = screenFontSize(x = 14.0).sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        TextFieldComposable(
            label = "Full name",
            value = "",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            ),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        TextFieldComposable(
            label = "Phone number",
            value = "",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Phone
            ),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        TextFieldComposable(
            label = "Email",
            value = "",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Email
            ),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        PasswordFieldComposable(
            label = "Password",
            value = "",
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Phone
            ),
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = "Already have an account? ")
            Text(
                color = MaterialTheme.colorScheme.surfaceTint,
                text = "Sign in",
                modifier = Modifier
                    .clickable {  }
            )
        }
        Spacer(modifier = Modifier.height(screenHeight(x = 16.0)))
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Sign up")
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegistrationScreenPreview() {
    AmshaTheme {
        RegistrationScreen()
    }
}