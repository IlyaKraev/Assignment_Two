const firstnameEl = document.querySelector('#firstname');
const lastnameEl = document.querySelector('#lastname');
const dobEl = document.querySelector('#dateofbirth');
const subjectEl = document.querySelector('#subject');


const form = document.querySelector('#trainer');

const checkfirstname = () => {

    let valid = false;

    const min = 2,
            max = 45;

    const firstname = firstnameEl.value.trim();

    if (!isRequired(firstname)) {
        showError(firstnameEl, 'First name cannot be blank.');
    } else if (!isBetween(firstname.length, min, max)) {
        showError(firstnameEl, `First name must be between ${min} and ${max} characters.`)
    } else if (!isFirstNameValid(firstname)) {
        showError(firstnameEl, 'First name is not valid.')
    } else {
        showSuccess(firstnameEl);
        valid = true;
    }
    return valid;
};

const checklastname = () => {

    let valid = false;

    const min = 2,
            max = 45;

    const lastname = lastnameEl.value.trim();

    if (!isRequired(lastname)) {
        showError(lastnameEl, 'Last name cannot be blank.');
    } else if (!isBetween(lastname.length, min, max)) {
        showError(lastnameEl, `Last name must be between ${min} and ${max} characters.`)
    } else if (!isLastNameValid(lastname)) {
        showError(lastnameEl, 'Last name is not valid.')
    } else {
        showSuccess(lastnameEl);
        valid = true;
    }
    return valid;
};


const checkDob = () => {
    let valid = false;
    const dob = dobEl.value.trim();
    if (!isRequired(dob)) {
        showError(dobEl, 'Date of birth cannot be blank.');
    } else {
        showSuccess(dobEl);
        valid = true;
    }
    return valid;
};

const checksubject = () => {

    let valid = false;

    const min = 2,
            max = 60;

    const subject = subjectEl.value.trim();

    if (!isRequired(subject)) {
        showError(subjectEl, 'Subject cannot be blank.');
    } else if (!isBetween(subject.length, min, max)) {
        showError(subjectEl, `Subject must be between ${min} and ${max} characters.`)
    } else if (!isSubjectValid(subject)) {
        showError(subjectEl, 'Subject is not valid.')
    } else {
        showSuccess(subjectEl);
        valid = true;
    }
    return valid;
};


const isRequired = value => value === '' ? false : true;
const isBetween = (length, min, max) => length < min || length > max ? false : true;


const showError = (input, message) => {
    // get the form-field element
    const formField = input.parentElement;
    // add the error class
    formField.classList.remove('success');
    formField.classList.add('error');

    // show the error message
    const error = formField.querySelector('small');
    error.textContent = message;
};

const showSuccess = (input) => {
    const formField = input.parentElement;

    formField.classList.remove('error');
    formField.classList.add('success');

    const error = formField.querySelector('small');
    error.textContent = '';
}

const isFirstNameValid = (firstname) => {
    const re = /^[a-zA-Z]*$/;
    return re.test(firstname);
}

const isLastNameValid = (lastname) => {
    const re = /^[a-zA-Z]*$/;
    return re.test(lastname);
}

const isSubjectValid = (subject) => {
    const re = /^\s*[A-Za-z0-9]+(?:\s+[A-Za-z0-9]+)*\s*$/;
    return re.test(subject);
};

form.addEventListener('submit', function (e) {
    // prevent the form from submitting
    e.preventDefault();

    // validate fields
    let isfirstnameValid = checkfirstname(),
            isLastNameValid = checklastname(),
            isDoBvalid = checkDob(),
            isSubjectValid = checksubject();

    let isFormValid = isfirstnameValid &&
            isLastNameValid &&
            isDoBvalid &&
            isSubjectValid;

    // submit if the form is valid
    if (isFormValid) {
        form.submit();
        form.reset();
    }
});

form.addEventListener('input', debounce(function (e) {
    switch (e.target.id) {
        case 'firstname':
            checkfirstname();
            break;
        case 'lastname':
            checklastname();
            break;
        case 'dateofbirth':
            checkDob();
            break;
        case 'subject':
            checksubject();
    }
}, 1000));


