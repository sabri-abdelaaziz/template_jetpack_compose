import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen() {
    val scope = rememberCoroutineScope()
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true) // Material 3 Bottom Sheet State

    // Scaffold with a centered button
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { padding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Button(onClick = {
                    scope.launch {
                        sheetState.show()  // Show bottom sheet on button click
                    }
                }) {
                    Text("Show Bottom Sheet")
                }
            }
        }
    )

    // Modal Bottom Sheet content
    ModalBottomSheet(
        onDismissRequest = {
            scope.launch {
                sheetState.hide()  // Hide the bottom sheet on dismiss request
            }
        },
        sheetState = sheetState,
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),  // Rounded corners for the sheet
        containerColor = Color.White  // Background color of the sheet
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            // Title
            Text(
                text = "Bottom Sheet Title",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Description text
            Text(
                text = "This is a professional bottom sheet. It includes a title, description, and action buttons at the bottom for user interaction.",
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Action buttons
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(onClick = {
                    scope.launch {
                        sheetState.hide()  // Hide bottom sheet
                    }
                }) {
                    Text("Cancel", color = MaterialTheme.colorScheme.primary)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(onClick = {
                    // Add your action here
                    scope.launch {
                        sheetState.hide()
                    }
                }) {
                    Text("Confirm")
                }
            }
        }
    }
}
