function openModal(index) {
  document.getElementById('modal-' + index).classList.remove('hidden');
}

function closeAllModals() {
  document.querySelectorAll('[id^="modal-"]').forEach(modal => {
    modal.classList.add('hidden');
  });
}